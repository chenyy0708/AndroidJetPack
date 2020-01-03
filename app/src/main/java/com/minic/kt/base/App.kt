package com.minic.kt.base

import com.minic.base.base.BaseApp
import com.minic.imageload.ImageFrom
import com.minic.kt.utils.GlideImageLoader
import com.minic.push.base.CPushManager
import com.minic.push.oppo.OPPOPush
import com.minic.push.xiaomi.XMPush

/**
 * @author       :ChenYangYi
 * @date         :2018/10/11/15:26
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class App : BaseApp() {
    override fun onCreate() {
        INSTANCE = this
        super.onCreate()
        ImageFrom.setImageLoader(GlideImageLoader())
        CPushManager.getInstance()
                .addPush(OPPOPush())
                .addPush(XMPush())
                .initPush(this)

    }

    companion object {
        lateinit var INSTANCE: App
    }
}