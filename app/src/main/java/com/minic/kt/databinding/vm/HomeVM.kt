package com.minic.kt.databinding.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.minic.base.extens.logD
import com.minic.kt.base.BaseVM
import com.minic.kt.ext.awaitResponse
import kotlinx.coroutines.launch

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeVM : BaseVM() {
    val name = MutableLiveData<String>()
    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        super.onCreate(lifecycleOwner)
        chapters()
    }

    private fun chapters() {
        try {
            coroutine.launch {
                logD("HomeVM", "launch:${Thread.currentThread().name}")
                wanAndroidService.chaptersAsync().awaitResponse {
                    logD("HomeVM", "Error:${Thread.currentThread().name}")
                    throwable.postValue(it)
                }?.apply {
                    logD("HomeVM", "Success:${Thread.currentThread().name}")
                    name.postValue(this[0].name)// 获取数据成功
                }
            }

        } catch (e: Exception) {
            println(e.localizedMessage)
        }
    }

}


