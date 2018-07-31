package com.sskj.rxkotlin.injection.component

import android.content.Context
import com.sskj.rxkotlin.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * ProjectName：
 * DESC: 每个项目都要又一个全局的AppComponent ,用于提供全局的context
 * Created by lez on 2018/7/18 18:10
 * updateName:
 * updateTime:
 * updateDesc:
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): Context
}