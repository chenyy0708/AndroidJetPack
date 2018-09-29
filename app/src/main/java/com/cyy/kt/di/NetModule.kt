package com.cyy.kt.di

import com.cyy.kt.net.UrlConstanct
import com.cyy.kt.net.api.DouBanService
import com.google.gson.Gson
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NET_MODEUL_TAG = "NET_MODEUL_TAG"
const val HTTP_CLIENT_MODULE_INTERCEPTOR_LOG_TAG = "http_client_module_interceptor_log_tag"
/**
 * 超时时间
 */
val CONNECT_TIME_OUT: Long = 1000 * 10

/**
 * 提供全局的ApiService，Retrofit等
 */
val httpClientModule = Kodein.Module(NET_MODEUL_TAG) {

    bind<Retrofit.Builder>() with provider {
        Retrofit.Builder()
    }

    bind<OkHttpClient.Builder>() with provider {
        RetrofitUrlManager.getInstance().with(OkHttpClient.Builder())
    }

    /**
     * 全局Retrofit
     */
    bind<Retrofit>() with singleton {
        instance<Retrofit.Builder>()
                .baseUrl(UrlConstanct.DOUBAN_URL)
                .client(instance())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    bind<Interceptor>(HTTP_CLIENT_MODULE_INTERCEPTOR_LOG_TAG) with singleton {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    /**
     * 全局OkHttpClient
     */
    bind<OkHttpClient>() with singleton {
        instance<OkHttpClient.Builder>()
                .readTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(instance(HTTP_CLIENT_MODULE_INTERCEPTOR_LOG_TAG))
                .build()
    }

    bind<Gson>() with singleton { Gson() }

    /**
     * 全局豆瓣 ApiService
     */
    bind<DouBanService>() with singleton {
        instance<Retrofit>().create(DouBanService::class.java)
    }
}