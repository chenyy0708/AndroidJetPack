package com.minic.base.base

import android.app.Application
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import com.minic.base.callback.ErrorCallback
import com.minic.base.callback.LoadingCallback

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:46
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
open class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // 初始化多状态布局
        LoadSir.beginBuilder()
                .addCallback(LoadingCallback())
                .addCallback(ErrorCallback())
                .setDefaultCallback(SuccessCallback::class.java)
                .commit()
    }
}