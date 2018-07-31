package com.sskj.rxkotlin.base

/**
 * ProjectName：
 * DESC:
 * Created by lez on 2018/7/18 14:54
 * updateName:
 * updateTime:
 * updateDesc:
 */
class BaseResp<T>(val status: Int,val message: String,val data:T)