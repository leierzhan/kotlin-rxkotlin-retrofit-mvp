package com.sskj.rxkotlin.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * ProjectName：
 * DESC:网络工具
 * Created by lez on 2018/7/23 17:53
 * updateName:
 * updateTime:
 * updateDesc:
 */
object NetWorkUtils {
    /**
     * 判断网络是否可用
     */
     fun isNetWorkAvailable(context: Context): Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
    /**
     * 检测wifi是否链接
     */
    fun isWifiConnected(context: Context): Boolean{
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo!=null && networkInfo.type == ConnectivityManager.TYPE_WIFI
    }
    /**
     * 检测3G是否链接
     */
    fun is3gConnected(context: Context):Boolean{
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.type == ConnectivityManager.TYPE_MOBILE
    }
}