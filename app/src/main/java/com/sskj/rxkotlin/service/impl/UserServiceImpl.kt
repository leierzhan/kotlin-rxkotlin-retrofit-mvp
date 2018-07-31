package com.sskj.rxkotlin.service.impl

import com.sskj.rxkotlin.data.entity.UserInfo
import com.sskj.rxkotlin.data.repository.UserRepository
import com.sskj.rxkotlin.ext.convert
import com.sskj.rxkotlin.service.UserService
import rx.Observable
import javax.inject.Inject

/**
 * ProjectName：
 * DESC:
 * Created by lez on 2018/7/18 13:42
 * updateName:
 * updateTime:
 * updateDesc:
 */
class UserServiceImpl @Inject constructor(): UserService {

    @Inject
    lateinit var repository: UserRepository

    //登录
    override fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {
        return repository.login(mobile,pwd,pushId).convert()
    }

}