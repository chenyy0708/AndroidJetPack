package com.cyy.base.base

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.cyy.base.callback.ErrorCallback
import com.cyy.base.callback.LoadingCallback
import com.cyy.base.di.httpClientModule
import com.cyy.base.net.UrlConstanct
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import org.kodein.di.Kodein
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
open class BaseApp : MultiDexApplication() {

    val baseKodein: Kodein = Kodein.lazy {
        bind<Context>() with singleton { this@BaseApp }
        import(androidModule(this@BaseApp))
        import(androidSupportModule(this@BaseApp))

        import(httpClientModule)
    }

    override fun onCreate() {
        super.onCreate()
        // 动态切换Retrofit BaseUrl
        RetrofitUrlManager.getInstance().putDomain(UrlConstanct.DOUBAN, UrlConstanct.DOUBAN_URL)
        RetrofitUrlManager.getInstance().putDomain(UrlConstanct.GANK, UrlConstanct.GANK_URL)
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