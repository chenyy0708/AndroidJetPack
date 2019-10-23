package com.minic.kt.data

import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.minic.base.BuildConfig
import com.minic.base.net.UrlConstant
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 描述: 生成ApiService
 * 作者: ChenYy
 * 日期: 2019-10-23 15:01
 */
object RetrofitProvider {

    const val CONNECT_TIME_OUT: Long = 1000 * 30

    private val retrofit: Retrofit by lazy {
        val loggerInterceptor = LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .setLevel(Level.BASIC)
                .log(Platform.INFO)
                .build()
        val okHttpClient = OkHttpClient.Builder()
                .readTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(loggerInterceptor)
                .build()
        Retrofit.Builder().baseUrl(UrlConstant.WAN_ANDROID_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun <T> createService(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}