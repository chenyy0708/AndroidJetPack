package com.cyy.kt.net

import com.cyy.kt.net.api.DouBanService
import com.cyy.kt.net.api.GankService
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:13
 * @description  :单例Retrofit管理类
 * @github       :https://github.com/chenyy0708
 */

class NetManager private constructor() {

    /**
     * 超时时间
     */
    private val CONNECT_TIME_OUT: Long = 1000 * 10
    private var mRetrofit: Retrofit
    private var mDouban: DouBanService
    private var mGank: GankService

    init {
        val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val mOkHttpClient: OkHttpClient = RetrofitUrlManager.getInstance().with(OkHttpClient.Builder())
                .readTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor)
                .build()

        mRetrofit = Retrofit.Builder()
                .baseUrl(UrlConstanct.DOUBAN_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build()
        mDouban = mRetrofit.create(DouBanService::class.java)
        mGank = mRetrofit.create(GankService::class.java)
    }

    fun getGank() = mGank

    fun getDouBan() = mDouban

    /**
     * 内部类单例模式
     */
    companion object {
        fun getInstance(): NetManager {
            return Holder.instance
        }
    }

    private object Holder {
        val instance = NetManager()
    }


}