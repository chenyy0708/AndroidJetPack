package com.minic.kt.ui.fragment.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.minic.base.extens.logD
import com.minic.kt.base.BaseVM
import com.minic.kt.data.WARepository
import com.minic.kt.data.model.gank.home.ArticleData
import com.minic.kt.ext.awaitResponse
import com.minic.kt.jetpack.paging.loadData
import kotlinx.coroutines.launch

class ProjectChildVM(private val cid: Int) : BaseVM() {
    var mList = loadData<ArticleData> { page, _, callback ->
        viewModelScope.launch {
            logD(msg = "加载数据$page")
            if (page == 1) {
                refreshComplete.value = true
            }
            WARepository.projectList(page, cid).awaitResponse {
                throwable.value = it
            }?.let {
                callback.onResult(it.datas)
            }
        }
    }
    val refreshComplete = MutableLiveData<Boolean>()
}