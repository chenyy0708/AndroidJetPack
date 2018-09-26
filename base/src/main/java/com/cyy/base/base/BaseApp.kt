package com.cyy.base.base

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import kotlin.properties.Delegates

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/12:59
 * @description  :Application
 * @github       :https://github.com/chenyy0708
 */
open class BaseApp : MultiDexApplication() {

    companion object {
        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}