package com.sskj.rxkotlin.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * ProjectName：
 * DESC:Activity管理器 单例
 * Created by lez on 2018/7/23 14:19
 * updateName:
 * updateTime:
 * updateDesc: 单例创建方式 首先有一个私有的构造方法
 *    有一个伴生对象
 *    val instance: AppManager by lazy {
 *        AppManager()
 *     }
 */
class AppManager private constructor(){

    private val activityStack: Stack<Activity> = Stack()

    companion object {
       val instance: AppManager by lazy {
           AppManager()
       }
    }
    //入栈
    fun addActivity(activity: Activity){
        activityStack.add(activity)
    }
    //出栈
    fun finishActivity(activity:Activity){
        activity.finish()
        activityStack.remove(activity)
    }
    //获取当前栈顶的activity
    fun currentActivity(): Activity{
        return activityStack.lastElement()
    }
    //清空栈
    fun finishAllActivity(){
        for (activity in activityStack){
            activity.finish()
        }
        activityStack.clear()
    }
    //退出App
    fun exitApp(context: Context){
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }
}