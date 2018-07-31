package com.sskj.rxkotlin.rx


import com.sskj.rxkotlin.base.BaseResp
import com.sskj.rxkotlin.common.ResultCode
import rx.Observable
import rx.functions.Func1

/**
 * ProjectName：
 * DESC: 数据解析基类 boolean类型
 * Created by lez on 2018/7/20 17:25
 * updateName:
 * updateTime:
 * updateDesc:
 */
class BaseFuncBoolean<T>: Func1<BaseResp<T>,Observable<Boolean>> {
    override fun call(t: BaseResp<T>): Observable<Boolean> {
        if(t.status != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.status,t.message))
        }
        return Observable.just(true)
    }
}