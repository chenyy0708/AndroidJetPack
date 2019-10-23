package com.minic.kt.ui.fragment.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import com.minic.base.databinding.viewmodel.SingleLiveEvent
import com.minic.kt.base.BaseVM
import com.minic.kt.data.WARepository
import com.minic.kt.data.model.gank.home.SystemTree
import com.minic.kt.ext.awaitResponse
import kotlinx.coroutines.launch

/**
 * @author       :ChenYangYi
 * @date         :2019年09月27日15:00:19
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class SystemChildVM : BaseVM() {

    val systemData = SingleLiveEvent<MutableList<SystemTree>>()

    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        super.onCreate(lifecycleOwner)
        viewModelScope.launch {
            WARepository.systemTree().awaitResponse()?.let { systemData.value = it }
        }
    }
}


