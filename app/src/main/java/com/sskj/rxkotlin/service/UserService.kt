package com.sskj.rxkotlin.service

import com.sskj.rxkotlin.data.entity.UserInfo
import rx.Observable

/**
 * ProjectName：
 * DESC:
 * Created by lez on 2018/7/18 13:40
 * updateName:
 * updateTime:
 * updateDesc:
 */

interface UserService {

  fun login(mobile: String,pwd: String,pushId: String): Observable<UserInfo>

}
