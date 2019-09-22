package com.minic.kt.ui.fragment.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minic.base.databinding.viewmodel.SingleLiveEvent
import com.minic.kt.base.BaseVM
import com.minic.kt.data.model.gank.home.ProjectTree
import com.minic.kt.ext.awaitResponse
import kotlinx.coroutines.launch

class HomeProjectVM : BaseVM() {

    val mList: MutableLiveData<MutableList<ProjectTree>> = SingleLiveEvent()

    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        super.onCreate(lifecycleOwner)
        viewModelScope.launch {
            repository.projectTree().awaitResponse {
            }?.let {
                mList.value = it
            }
        }
    }
}