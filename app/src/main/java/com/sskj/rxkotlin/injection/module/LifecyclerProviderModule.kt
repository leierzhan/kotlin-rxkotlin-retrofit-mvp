package com.sskj.rxkotlin.injection.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * ProjectName：
 * DESC: RxLifecycler 用于绑定RxKotlin,防止内存泄露
 * Created by lez on 2018/7/18 18:16
 * updateName:
 * updateTime:
 * updateDesc:
 */
@Module
class LifecyclerProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {
    @Provides
    fun providesLifecycleProvider(): LifecycleProvider<*> {
        return lifecycleProvider
    }
}