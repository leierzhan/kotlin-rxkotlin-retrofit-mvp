package com.sskj.rxkotlin.data.entity

/**
 * ProjectName：
 * DESC:用户信息实体类
 * Created by lez on 2018/7/24 14:26
 * updateName:
 * updateTime:
 * updateDesc:
 */
data class UserInfo(val id:String,
                    val userIcon:String,
                    val userName:String,
                    val userGender:String,
                    val userMobile:String,
                    val userSign:String) {
}