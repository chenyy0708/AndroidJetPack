package com.minic.kt.databinding.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.minic.base.extens.logD
import com.minic.kt.base.BaseVM
import com.minic.kt.ext.awaitResponse
import kotlinx.coroutines.delay
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
        coroutine.launch {
            delay(3000L)
            wanAndroidService.chaptersAsync().awaitResponse {
                throwable.postValue(it)
            }?.apply {
                logD(tag = "HomeVM", msg = "获取数据成功")
                name.postValue(this[0].name)// 获取数据成功
            }

        }
    }

}


