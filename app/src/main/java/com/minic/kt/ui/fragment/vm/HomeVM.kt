package com.minic.kt.ui.fragment.vm

import androidx.lifecycle.MutableLiveData
import com.minic.base.extens.logD
import com.minic.kt.base.BaseVM
import com.minic.kt.data.model.gank.Android
import com.minic.kt.ext.awaitV2Response
import com.minic.kt.jetpack.paging.loadData
import kotlinx.coroutines.launch

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeVM : BaseVM() {
    var mList = loadData<Android> { page, rows, callback ->
        logD(msg = "加载第${page}页数据")
        coroutine.launch {
            if (page == 1) { // 刷新完成
                refreshComplete.value = true
            }
            gankRepository.androidListAsync(page, rows).awaitV2Response {
                throwable.value = it
            }?.apply {
                callback.onResult(this)
            }
        }
    }
    val refreshComplete = MutableLiveData<Boolean>()
}


