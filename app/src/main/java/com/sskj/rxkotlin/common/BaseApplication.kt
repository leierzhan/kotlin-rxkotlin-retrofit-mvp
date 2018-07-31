package com.sskj.rxkotlin.common

import android.app.Application
import android.content.Context
import com.sskj.rxkotlin.injection.component.AppComponent
import com.sskj.rxkotlin.injection.component.DaggerAppComponent
import com.sskj.rxkotlin.injection.module.AppModule

/**
 * ProjectName：
 * DESC:
 * Created by lez on 2018/7/18 18:11
 * updateName:
 * updateTime:
 * updateDesc:
 */
open class BaseApplication:Application() {
    lateinit var appComponent: AppComponent

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        initAppInjection()
        context=this
    }
    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}