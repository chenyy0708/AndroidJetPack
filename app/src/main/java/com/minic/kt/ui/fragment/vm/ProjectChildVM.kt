package com.minic.kt.ui.fragment.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minic.kt.base.BaseVM
import com.minic.kt.data.model.gank.home.ArticleData
import com.minic.kt.ext.awaitResponse
import com.minic.kt.jetpack.paging.loadData
import kotlinx.coroutines.launch

class ProjectChildVM(private val cid: Int) : BaseVM() {
    var mList = loadData<ArticleData> { page, _, callback ->
        viewModelScope.launch {
            if (page == 1) {
                refreshComplete.value = true
            }
            repository.projectList(page, cid).awaitResponse {
                throwable.value = it
            }?.let {
                callback.onResult(it.datas)
            }
        }
    }
    val refreshComplete = MutableLiveData<Boolean>()
}