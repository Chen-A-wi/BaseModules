package com.awilab.network

import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

fun createOkHttpClient(): OkHttpClient {
	return OkHttpClient.Builder()
		.retryOnConnectionFailure(true)
//		.addNetworkInterceptor(LoggerInterceptor())
		.connectTimeout(60L, TimeUnit.SECONDS)
		.readTimeout(60L, TimeUnit.SECONDS)
		.connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
		.build()
}