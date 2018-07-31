package com.sskj.rxkotlin.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * ProjectName：
 * DESC: 提供全局的activity
 * Created by lez on 2018/7/18 18:16
 * updateName:
 * updateTime:
 * updateDesc:
 */
@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    fun providesActivity(): Activity {
        return activity
    }
}