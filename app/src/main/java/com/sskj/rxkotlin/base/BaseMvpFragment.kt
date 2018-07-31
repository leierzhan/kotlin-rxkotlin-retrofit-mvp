package com.sskj.rxkotlin.base

import android.os.Bundle
import com.sskj.rxkotlin.common.BaseApplication
import com.sskj.rxkotlin.injection.component.ActivityComponent
import com.sskj.rxkotlin.injection.component.DaggerActivityComponent
import com.sskj.rxkotlin.injection.module.ActivityModule
import com.sskj.rxkotlin.injection.module.LifecyclerProviderModule
import com.sskj.rxkotlin.widget.ProgressLoading
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * ProjectName：
 * DESC:
 * Created by lez on 2018/7/18 10:59
 * updateName:
 * updateTime:
 * updateDesc:
 */
open abstract class BaseMvpFragment<T: BasePresenter<*>>: BaseFragment(),BaseView {
    @Inject
    lateinit var mPresenter: T
    lateinit var activityComponent: ActivityComponent
    private lateinit var mProgressLoading: ProgressLoading

    override fun showLoading() {
        mProgressLoading.showLoading()
    }
    override fun hideLoading() {
        mProgressLoading.hideLoading()
    }
    override fun onError(text:String) {
        toast(text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
        mProgressLoading = ProgressLoading.create(activity!!)
    }
    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().
                appComponent((activity!!.application as BaseApplication).appComponent).
                activityModule(ActivityModule(activity!!))
                .lifecyclerProviderModule(LifecyclerProviderModule(this))
                .build()
    }
}