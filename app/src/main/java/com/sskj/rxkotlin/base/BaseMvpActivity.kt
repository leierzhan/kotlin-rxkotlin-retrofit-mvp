package com.sskj.rxkotlin.base

import android.os.Bundle
import com.sskj.rxkotlin.common.BaseApplication
import com.sskj.rxkotlin.injection.component.ActivityComponent
import com.sskj.rxkotlin.injection.component.DaggerActivityComponent
import com.sskj.rxkotlin.injection.module.ActivityModule
import com.sskj.rxkotlin.injection.module.LifecyclerProviderModule
import com.sskj.rxkotlin.widget.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * ProjectName：
 * DESC:MvpActivity基类，所有Mvp类型的Activity都继承这个类
 * Created by lez on 2018/7/18 10:59
 * updateName:
 * updateTime:
 * updateDesc:
 */
open abstract class BaseMvpActivity<T: BasePresenter<*>>: BaseActivity(),BaseView {

    //Presenter泛型，Dagger注入
    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    private lateinit var mLoadingDialog: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

        //初始加载框
        mLoadingDialog = ProgressLoading.create(this)
    }

    /*
        Dagger注册
     */
    protected abstract fun injectComponent()

    /*
        初始Activity Component
     */
    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecyclerProviderModule(LifecyclerProviderModule(this))
                .build()

    }
    /*
        显示加载框，默认实现
     */
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }
    /*
        隐藏加载框，默认实现
     */
    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }
    /*
        错误信息提示，默认实现
     */
    override fun onError(text:String) {
        toast(text)
    }
}