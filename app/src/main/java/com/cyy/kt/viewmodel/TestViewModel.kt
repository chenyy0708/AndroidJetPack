package com.cyy.kt.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.cyy.base.extens.async
import com.cyy.base.extens.bindLifecycle
import com.cyy.kt.base.BaseViewModel

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class TestViewModel : BaseViewModel() {

    val name = MutableLiveData<String>()

    var url = MutableLiveData<String>()

    fun getLiveDataName(): MutableLiveData<String> = name

    fun getData() {
        douBanService
                .getDouBanBook()
                .async(4000)
                // 线程切换 + 自动绑定Activity/Fragment生命周期取消订阅
                .bindLifecycle(this)
                .subscribe {
                    name.postValue(it.alt)
                    url.postValue(it.publisher)
                }
    }
}