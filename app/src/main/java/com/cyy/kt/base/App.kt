package com.cyy.kt.base

import android.content.Context
import com.cyy.base.base.BaseApp
import com.cyy.kt.di.httpClientModule
import com.cyy.kt.net.UrlConstanct
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
    }

    companion object {
        lateinit var INSTANCE: App
    }
}