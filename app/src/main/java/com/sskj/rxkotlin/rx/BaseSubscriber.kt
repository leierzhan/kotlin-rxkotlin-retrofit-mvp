package com.sskj.rxkotlin.rx

import com.sskj.rxkotlin.base.BaseView
import rx.Subscriber

/**
 * ProjectName：
 * DESC: Rxkotlin回调封装，用的时候只要重写onNext()即可
 * Created by lez on 2018/7/18 14:01
 * updateName:
 * updateTime:
 * updateDesc:
 */
open class BaseSubscriber<T>(val baseView: BaseView): Subscriber<T>() {

    override fun onNext(t: T) {
    }
    override fun onCompleted() {
        baseView.hideLoading()
    }
    override fun onError(e: Throwable?) {
        baseView.hideLoading()
        if(e is BaseException){
            baseView.onError(e.msg)
        }
    }

}