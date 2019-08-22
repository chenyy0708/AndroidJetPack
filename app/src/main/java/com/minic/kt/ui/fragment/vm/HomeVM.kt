package com.minic.kt.ui.fragment.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minic.base.extens.logD
import com.minic.kt.base.BaseVM
import com.minic.kt.data.model.gank.Android
import com.minic.kt.ext.awaitV2Response
import com.minic.kt.jetpack.paging.loadData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeVM(private val typeName: String) : BaseVM() {

    var mList = loadData<Android> { page, rows, callback ->
        logD(msg = "加载第${page}页数据")
        viewModelScope.launch {
            delay(3000)
            logD(tag = "sfwewfe", msg = "数据加载${Thread.currentThread().name}")
            if (page == 1) { // 刷新完成
                refreshComplete.value = true
            }
            gankRepository.androidListAsync(page, rows, typeName).awaitV2Response {
                throwable.value = it
            }?.apply {
                callback.onResult(this)
            }
        }
    }


    val refreshComplete = MutableLiveData<Boolean>()
}


