package com.minic.kt.ui.fragment.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minic.kt.base.BaseVM
import com.minic.kt.data.model.gank.home.BannerData
import com.minic.kt.ext.awaitResponse
import kotlinx.coroutines.launch

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeVM(private val typeName: String) : BaseVM() {

     val banners: MutableLiveData<MutableList<BannerData>> = MutableLiveData()

    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        super.onCreate(lifecycleOwner)
        viewModelScope.launch {
            repository.banners().awaitResponse {
                throwable.value = it
            }?.apply {
                banners.value = this
            }
        }
    }
}


