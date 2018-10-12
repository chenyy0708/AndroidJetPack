package com.cyy.kt.databinding.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.cyy.base.base.viewmodel.BaseViewModel
import com.cyy.base.extens.async
import com.cyy.base.extens.bindLifecycle
import com.cyy.base.net.BaseObserver
import com.cyy.kt.model.data.Book

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class TestViewModel : BaseViewModel() {

    val name = MutableLiveData<String>()

    val url = MutableLiveData<String>()

    fun getData() {
        douBanService.getDouBanBook()
                .async(2000)
                .bindLifecycle(this)
                .subscribe(object : BaseObserver<Book>(throwable) {
                    override fun onNext(douBanBook: Book) {
                        name.postValue(douBanBook.alt)
                        url.postValue(douBanBook.image)
                    }
                })
    }
}