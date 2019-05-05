package com.minic.kt.base

import androidx.lifecycle.MutableLiveData
import com.minic.base.databinding.viewmodel.LifecycleViewModel
import com.minic.kt.model.remote.api.WanAndroidService
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
    protected val douBanService: WanAndroidService by instance()
}