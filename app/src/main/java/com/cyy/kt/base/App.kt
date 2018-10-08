package com.cyy.kt.base

import android.content.Context
import com.cyy.base.base.BaseApp
import com.cyy.kt.di.httpClientModule
import com.cyy.kt.net.UrlConstanct
import com.cyy.kt.ui.callback.ErrorCallback
import com.cyy.kt.ui.callback.LoadingCallback
import com.facebook.stetho.Stetho
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule
import org.kodein.di.android.support.androidSupportModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:46
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class App : BaseApp(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        bind<Context>() with singleton { this@App }
        import(androidModule(this@App))
        import(androidSupportModule(this@App))

        import(httpClientModule)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        // 动态切换Retrofit BaseUrl
        RetrofitUrlManager.getInstance().putDomain(UrlConstanct.DOUBAN, UrlConstanct.DOUBAN_URL)
        RetrofitUrlManager.getInstance().putDomain(UrlConstanct.GANK, UrlConstanct.GANK_URL)
        // 初始化多状态布局
        LoadSir.beginBuilder()
                .addCallback(LoadingCallback())
                .addCallback(ErrorCallback())
                .setDefaultCallback(SuccessCallback::class.java)
                .commit()
        Stetho.initializeWithDefaults(this)
    }

    companion object {
        lateinit var INSTANCE: App
    }
}