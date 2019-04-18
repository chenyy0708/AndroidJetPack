package com.cyy.kt.databinding.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.cyy.kt.base.BaseViewModel
import com.cyy.base.extens.async
import com.cyy.base.extens.bindLifecycle
import com.cyy.base.net.BaseObserver
import com.cyy.kt.model.data.Book
import com.cyy.kt.model.data.Gank

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeViewModel : BaseViewModel() {

    val name = MutableLiveData<String>()

    val url = MutableLiveData<String>()

    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        super.onCreate(lifecycleOwner)
        // 获取数据
        getData()


    }

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
        douBanService.getGank()
                .bindLifecycle(this)
                .subscribe(object : BaseObserver<Gank>(throwable) {
                    override fun onNext(gank: Gank) {
                        name.postValue(gank.results[0].url)
                    }
                })
    }
}