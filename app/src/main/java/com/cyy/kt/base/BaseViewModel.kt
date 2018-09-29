package com.cyy.kt.base

import com.cyy.base.base.viewmodel.LifecycleViewModel
import com.cyy.kt.net.api.DouBanService
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

open class BaseViewModel : LifecycleViewModel(),KodeinAware {
    /**
     * 全局Kodein
     */
    override val kodein: Kodein = App.INSTANCE.kodein

    /**
     * Application中注入的ApiService
     */
    protected val douBanService: DouBanService by instance()
}