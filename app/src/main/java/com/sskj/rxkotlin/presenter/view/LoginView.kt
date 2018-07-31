package com.sskj.rxkotlin.presenter.view

import com.sskj.rxkotlin.base.BaseView
import com.sskj.rxkotlin.data.entity.UserInfo

/**
 * ProjectName：
 * DESC:
 * Created by lez on 2018/7/18 11:08
 * updateName:
 * updateTime:
 * updateDesc:
 */
interface LoginView: BaseView {
   fun onLoginResult(result: UserInfo)
}