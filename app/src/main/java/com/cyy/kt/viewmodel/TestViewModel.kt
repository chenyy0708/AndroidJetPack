package com.cyy.kt.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.cyy.base.rx.applySchedulers
import com.cyy.kt.net.NetManager
import io.reactivex.rxkotlin.subscribeBy

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class TestViewModel : ViewModel() {
    val name = MutableLiveData<String>()

    var url = MutableLiveData<String>()

    fun getData() {
        NetManager.getInstance()
                .getDouBan()
                .getDouBanBook()
                .compose(applySchedulers())
                .subscribeBy {
                    name.postValue(it.alt)
                    url.postValue(it.publisher)
                }
    }

}