package com.sskj.rxkotlin.rx

/**
* ProjectName：
* DESC: 数据解析异常基类
* Created by lez on 2018/7/18 15:21
* updateName:
* updateTime:
* updateDesc:
*/
class BaseException(val status: Int,val msg:String): Throwable() {
}