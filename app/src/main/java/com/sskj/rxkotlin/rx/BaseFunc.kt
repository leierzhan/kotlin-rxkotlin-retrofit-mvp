package com.sskj.rxkotlin.rx

import com.sskj.rxkotlin.base.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * ProjectName：
 * DESC: 数据解析基类
 * Created by lez on 2018/7/20 17:25
 * updateName:
 * updateTime:
 * updateDesc:
 */
class BaseFunc<T>: Func1<BaseResp<T>,Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if(t.status != 0){
            return Observable.error(BaseException(t.status,t.message))
        }
        return Observable.just(t.data)
    }
}