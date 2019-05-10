package com.minic.kt.base

import com.minic.base.base.BaseApp
import com.minic.kt.data.GankRepository
import com.minic.kt.data.api.GankService
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

/**
 * @author       :ChenYangYi
 * @date         :2018/10/11/15:26
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class App : BaseApp(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        // 导入基类中的Kodein，存储公共的全局实例
        extend(baseKodein)
        bind<GankService>() with singleton {
            instance<Retrofit>().create(GankService::class.java)
        }
        bind<GankRepository>() with singleton {
            GankRepository(instance())
        }
    }

    override fun onCreate() {
        INSTANCE = this
        super.onCreate()
    }


    companion object {
        lateinit var INSTANCE: App
    }
}