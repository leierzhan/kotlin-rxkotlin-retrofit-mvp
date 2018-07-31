package com.sskj.rxkotlin.base

/**
 * ProjectName：
 * DESC:
 * Created by lez on 2018/7/18 10:57
 * updateName:
 * updateTime:
 * updateDesc:
 */
interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun onError(text: String)
}