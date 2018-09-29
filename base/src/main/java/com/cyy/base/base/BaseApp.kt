package com.cyy.base.base

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/12:59
 * @description  :Application
 * @github       :https://github.com/chenyy0708
 */
open class BaseApp : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}