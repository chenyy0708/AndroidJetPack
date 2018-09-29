package com.cyy.kt.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.cyy.base.base.viewmodel.LifecycleViewModel
import com.cyy.base.extens.bindLifecycle
import com.cyy.kt.base.App
import com.cyy.kt.net.api.DouBanService
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class TestViewModel : LifecycleViewModel(), KodeinAware {
    /**
     * 全局Kodein
     */
    override val kodein: Kodein = App.INSTANCE.kodein

    /**
     * Application中注入的ApiService
     */
    protected val douBanService: DouBanService by instance()

    val name = MutableLiveData<String>()

    var url = MutableLiveData<String>()

    fun getData() {
        douBanService
                .getDouBanBook()
                // 线程切换 + 自动绑定Activity/Fragment生命周期取消订阅
                .bindLifecycle(this)
                .subscribe {
                    name.postValue(it.alt)
                    url.postValue(it.publisher)
                }
    }
}