package com.minic.base.base

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.minic.base.callback.ErrorCallback
import com.minic.base.callback.LoadingCallback
import com.minic.base.di.httpClientModule
import com.minic.base.net.UrlConstant
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import org.kodein.di.Kodein
import org.kodein.di.android.androidCoreModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:46
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
open class BaseApp : MultiDexApplication() {

    val baseKodein: Kodein = Kodein.lazy {
        bind<Context>() with singleton { this@BaseApp }
        import(androidCoreModule(this@BaseApp))
        import(httpClientModule)
    }

    override fun onCreate() {
        super.onCreate()
        // 动态切换Retrofit BaseUrl
        RetrofitUrlManager.getInstance().putDomain(UrlConstant.WAN_ANDROID, UrlConstant.WAN_ANDROID_URL)
        // 初始化多状态布局
        LoadSir.beginBuilder()
                .addCallback(LoadingCallback())
                .addCallback(ErrorCallback())
                .setDefaultCallback(SuccessCallback::class.java)
                .commit()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}