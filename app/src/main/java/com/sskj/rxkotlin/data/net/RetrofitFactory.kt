package com.sskj.rxkotlin.data.net

import com.sskj.rxkotlin.common.BaseConstant
import com.sskj.rxkotlin.utils.AppPrefsUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * ProjectName：
 * DESC: Retrofit单例工厂
 * Created by lez on 2018/7/18 14:33
 * updateName:
 * updateTime:
 * updateDesc:
 */
class RetrofitFactory private constructor(){
    //伴生对象
    companion object {
        val instance:RetrofitFactory by lazy { RetrofitFactory() }
    }
    private val retrofit: Retrofit
    //Header拦截器
    private val interceptor: Interceptor
    init {
        interceptor = Interceptor {
            chain ->
             val request = chain.request()
                     .newBuilder()
                     .addHeader("Content-Type","application/json")
                     .addHeader("charset","utf-8")
                     .addHeader("token", AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN))
                     .build()
            chain.proceed(request)
        }
        retrofit = Retrofit.Builder()
                .baseUrl(BaseConstant.server_address)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initClient())
                .build()
    }
    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(initLogInterceptor())
                .connectTimeout(10,TimeUnit.MINUTES)
                .readTimeout(10,TimeUnit.MINUTES)
                .build()
    }
    //日志拦截器
    private fun initLogInterceptor(): Interceptor {
      val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return  interceptor
    }
    fun <T> create(service: Class<T>): T{
        return retrofit.create(service)
    }
}