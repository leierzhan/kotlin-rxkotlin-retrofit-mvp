package com.sskj.rxkotlin.presenter

import com.sskj.rxkotlin.base.BasePresenter
import com.sskj.rxkotlin.data.entity.UserInfo
import com.sskj.rxkotlin.presenter.view.LoginView
import com.sskj.rxkotlin.rx.BaseSubscriber
import com.sskj.rxkotlin.service.UserService
import javax.inject.Inject
import com.sskj.rxkotlin.ext.excute

/**
 * ProjectName：
 * DESC: 登录Presenter,添加到Dagger2依赖容器，
 * Created by lez on 2018/7/18 11:07
 * updateName:
 * updateTime:
 * updateDesc:
 */
class LoginPresenter @Inject constructor(): BasePresenter<LoginView>() {
    @Inject
    lateinit var userService: UserService
    //登录
    fun login(mobile: String,pwd: String,pushId: String){
        /**
         * 业务逻辑
         */
        if(checkNetWork()){
            println("网络正常")
            mView.showLoading()
            userService.login(mobile,pwd,pushId)
                    .excute(object: BaseSubscriber<UserInfo>(mView){
                        override fun onNext(userInfo: UserInfo) {
                           mView.onLoginResult(userInfo)
                        }
                    },lifecycleProvider)
        }else{
            println("没有网络")
            return
        }
    }
}