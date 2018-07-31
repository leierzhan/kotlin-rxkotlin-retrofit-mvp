package com.sskj.rxkotlin.base

import android.content.Context
import com.sskj.rxkotlin.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * ProjectName：
 * DESC: Presenter基类，提供了presenter持有的View对象，Lifecycler,context
 * Created by lez on 2018/7/18 10:57
 * updateName:
 * updateTime:
 * updateDesc:
 */
open class BasePresenter<T: BaseView> {
    lateinit var mView: T
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>
    @Inject
    lateinit var context: Context

    fun checkNetWork():Boolean{
        if(NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络异常")
        return false
    }
}