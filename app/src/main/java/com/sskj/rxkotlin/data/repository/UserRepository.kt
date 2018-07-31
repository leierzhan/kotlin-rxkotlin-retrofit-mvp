package com.sskj.rxkotlin.data.repository

import com.sskj.rxkotlin.base.BaseResp
import com.sskj.rxkotlin.data.api.UserApi
import com.sskj.rxkotlin.data.entity.UserInfo
import com.sskj.rxkotlin.data.net.RetrofitFactory
import com.sskj.rxkotlin.data.protocol.LoginReq
import rx.Observable
import javax.inject.Inject

/**
 * ProjectName：
 * DESC:
 * Created by lez on 2018/7/18 15:08
 * updateName:
 * updateTime:
 * updateDesc:
 */
class UserRepository @Inject constructor(){
    //登录
    fun login(mobile: String,pwd: String,pushId: String): Observable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.create(UserApi::class.java)
                .login(LoginReq(mobile,pwd,pushId))
    }
}