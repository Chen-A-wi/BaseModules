package com.awilab.common.di

import com.awilab.common.DispatcherProvider
import com.awilab.common.DispatcherProviderImpl
import com.awilab.common.util.ReadAssets
import com.awilab.common.util.ReadAssetsImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val dispatcherProviderModule = module {
    single { DispatcherProviderImpl() } bind DispatcherProvider::class
}

val readAssetsModule = module {
    single { ReadAssetsImpl(get()) } bind ReadAssets::class
}