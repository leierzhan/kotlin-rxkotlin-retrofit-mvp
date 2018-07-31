package com.sskj.rxkotlin.ui.activity

import android.os.Bundle
import android.view.View
import com.sskj.rxkotlin.R
import com.sskj.rxkotlin.base.BaseMvpActivity
import com.sskj.rxkotlin.data.entity.UserInfo
import com.sskj.rxkotlin.ext.enable
import com.sskj.rxkotlin.ext.onClick
import com.sskj.rxkotlin.injection.component.DaggerUserComponent
import com.sskj.rxkotlin.injection.module.UserModule
import com.sskj.rxkotlin.presenter.LoginPresenter
import com.sskj.rxkotlin.presenter.view.LoginView
import com.sskj.rxkotlin.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
/**
 * ProjectName：
 * DESC: 登录Activity
 * Created by lez on 2018/7/18 18:10
 * updateName:
 * updateTime:
 * updateDesc:
 */
class MainActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }
    private fun initView(){
        mLoginBtn.enable(mMobileEt,{isBtnEnable()})
        mLoginBtn.enable(mPwdEt,{isBtnEnable()})
        mLoginBtn.onClick(this)
        mForgetPwdTv.onClick(this)
        mHeaderBar.getRightView().onClick(this)
        injectComponent()
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent)
                .userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    /**
     * 登录返回结果
     */
    override fun onLoginResult(result: UserInfo) {
        toast("登录成功")
        UserPrefsUtils.putUserInfo(result)
//        startActivity<UserInfoActivity>()
    }
    override fun onClick(view: View) {
        when(view.id){

            R.id.mRightTv -> {
//                startActivity<RegisterActivity>()
            }

            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(),mPwdEt.text.toString(),"")
            }

            R.id.mForgetPwdTv -> {
//                startActivity<ForgetPwdActivity>()
            }
        }
    }

    //判断登录按钮是否可用
    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}
