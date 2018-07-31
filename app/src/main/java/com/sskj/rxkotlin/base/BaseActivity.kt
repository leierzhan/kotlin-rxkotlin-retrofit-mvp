package com.sskj.rxkotlin.base

import android.os.Bundle
import com.sskj.rxkotlin.common.AppManager
import com.trello.rxlifecycle.components.support.RxAppCompatActivity

/**
 * ProjectName：
 * DESC:
 * Created by lez on 2018/7/18 10:59
 * updateName:
 * updateTime:
 * updateDesc:
 */
open class BaseActivity: RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        AppManager.instance.finishActivity(this)
    }
}