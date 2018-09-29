package com.cyy.kt.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.cyy.kt.extens.applySchedulers
import com.cyy.kt.net.NetManager
import io.reactivex.rxkotlin.subscribeBy

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class TestViewModel : ViewModel() {
    val name = ObservableField<String>()

    var url = ObservableField<String>()

    fun getData() {
        NetManager.getInstance()
                .getDouBan()
                .getDouBanBook()
                .applySchedulers()
                .subscribeBy {
                    name.set(it.alt)
                    url.set(it.publisher)
                }
    }

}