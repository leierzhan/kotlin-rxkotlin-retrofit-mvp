package com.sskj.rxkotlin.injection.component

import android.app.Activity
import android.content.Context
import com.sskj.rxkotlin.injection.module.ActivityModule
import com.sskj.rxkotlin.injection.module.LifecyclerProviderModule
import com.sskj.rxkotlin.injection.scope.ActivityScope
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * ProjectName：
 * DESC:
 * Created by lez on 2018/7/18 18:15
 * updateName:
 * updateTime:
 * updateDesc:
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class, LifecyclerProviderModule::class))
interface ActivityComponent {

    fun activity(): Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}