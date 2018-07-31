package com.sskj.rxkotlin.injection.component

import com.sskj.rxkotlin.injection.module.UserModule
import com.sskj.rxkotlin.injection.scope.PerComponentScope
import com.sskj.rxkotlin.ui.activity.MainActivity
import dagger.Component

/**
 * ProjectName：
 * DESC:
 * Created by lez on 2018/7/18 17:05
 * updateName:
 * updateTime:
 * updateDesc:
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {

    fun inject(activity: MainActivity)

}