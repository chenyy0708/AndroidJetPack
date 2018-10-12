package com.cyy.kt.databinding.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.cyy.base.base.viewmodel.BaseViewModel
import com.cyy.base.extens.async
import com.cyy.base.extens.bindLifecycle
import com.cyy.base.net.BaseObserver
import com.cyy.kt.db.database.BookDatabase
import com.cyy.kt.net.data.DouBanBook
import org.kodein.di.generic.instance

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class TestViewModel : BaseViewModel() {

    val name = MutableLiveData<String>()

    var url = MutableLiveData<String>()

    val bookDatabase: BookDatabase by instance()

    fun getData() {
        douBanService
                .getDouBanBook()
                .async(2000)
                // 线程切换 + 自动绑定Activity/Fragment生命周期取消订阅
                .bindLifecycle(this)
                .subscribe(object : BaseObserver<DouBanBook>(throwable) {
                    override fun onNext(douBanBook: DouBanBook) {
                        name.postValue(douBanBook.alt)
                        url.postValue(douBanBook.image)
                    }
                })

    }
}