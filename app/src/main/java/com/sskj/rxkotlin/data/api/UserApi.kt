package com.sskj.rxkotlin.data.api

import com.sskj.rxkotlin.base.BaseResp
import com.sskj.rxkotlin.data.entity.UserInfo
import com.sskj.rxkotlin.data.protocol.LoginReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * ProjectName：
 * DESC: 用户相关API
 * Created by lez on 2018/7/18 14:57
 * updateName:
 * updateTime:
 * updateDesc:
 */
interface UserApi {

    @POST("userCenter/login")
    fun login(@Body req: LoginReq): Observable<BaseResp<UserInfo>>
}