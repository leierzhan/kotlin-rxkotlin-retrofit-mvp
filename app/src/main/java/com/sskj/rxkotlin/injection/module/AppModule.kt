package com.sskj.rxkotlin.injection.module

import android.content.Context
import com.sskj.rxkotlin.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * ProjectName：
 * DESC: AppModule提供全局的context
 * Created by lez on 2018/7/18 18:10
 * updateName:
 * updateTime:
 * updateDesc:
 */
@Module
class AppModule(private val context: BaseApplication) {
    @Singleton
    @Provides
   fun providesActivity(): Context {
       return context
   }
}