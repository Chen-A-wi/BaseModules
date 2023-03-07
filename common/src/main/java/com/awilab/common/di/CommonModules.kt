package com.awilab.common.di

import com.awilab.common.DispatcherProviderImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val dispatcherProviderModule = module {
    single { DispatcherProviderImpl() } bind DispatcherProviderImpl::class
}