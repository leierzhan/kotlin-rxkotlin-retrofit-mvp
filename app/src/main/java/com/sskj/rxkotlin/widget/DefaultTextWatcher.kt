package com.sskj.rxkotlin.widget

import android.text.Editable
import android.text.TextWatcher

/**
 * ProjectName：
 * DESC:TextWatcher默认实现
 * Created by lez on 2018/7/24 10:46
 * updateName:
 * updateTime:
 * updateDesc:
 */
open class DefaultTextWatcher:TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
    override fun afterTextChanged(s: Editable?) {
    }
}