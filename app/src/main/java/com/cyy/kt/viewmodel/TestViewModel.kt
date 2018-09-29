package com.cyy.kt.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.cyy.base.extens.bindLifecycle
import com.cyy.kt.base.BaseViewModel
import org.kodein.di.KodeinAware

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class TestViewModel : BaseViewModel(), KodeinAware {

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