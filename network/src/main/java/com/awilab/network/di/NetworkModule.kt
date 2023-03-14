package com.awilab.network.di

import com.awilab.network.MoshiArrayListJsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkModule {
    val networkModule = module {
        single {
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .add(MoshiArrayListJsonAdapter.FACTORY)
                .build()
        }
    }

    inline fun <reified T> createService(
        okHttpClient: OkHttpClient,
        moshi: Moshi,
        serverUrl: String
    ): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(serverUrl) // 設定請求URL
            .client(okHttpClient) // 設定OkHttp攔截器
            .addConverterFactory(MoshiConverterFactory.create(moshi)) // 設定解析工具
            .build()

        return retrofit.create(T::class.java)
    }
}
