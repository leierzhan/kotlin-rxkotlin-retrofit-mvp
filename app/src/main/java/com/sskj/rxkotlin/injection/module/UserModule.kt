package com.sskj.rxkotlin.injection.module

import com.sskj.rxkotlin.service.UserService
import com.sskj.rxkotlin.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * ProjectName：
 * DESC:
 * Created by lez on 2018/7/18 17:00
 * updateName:
 * updateTime:
 * updateDesc:
 */
@Module
class UserModule {

  @Provides
  fun providesUserService(service: UserServiceImpl): UserService {
      return service
  }
}