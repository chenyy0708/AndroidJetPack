package com.cyy.base.base.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.cyy.kt.net.api.DouBanService
import com.cyy.kt.base.App
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

open class BaseViewModel : LifecycleViewModel(), KodeinAware {
    /**
     * 全局Kodein
     */
    override val kodein: Kodein = App.INSTANCE.kodein

    /**
     * 错误
     */
    open val throwable = MutableLiveData<Throwable>()

    /**
     * Application中注入的ApiService
     */
    protected val douBanService: DouBanService by instance()
}