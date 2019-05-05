package com.minic.kt.databinding.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.minic.kt.base.BaseViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeViewModel : BaseViewModel() {
    val name = MutableLiveData<String>()
    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        super.onCreate(lifecycleOwner)
        // 获取数据
        getData()
    }

    private fun getData() {
        GlobalScope.launch {
            val request = douBanService.chaptersAsync()
            try {
                val response = request.await()
                name.postValue(response.data[0].name)
            } catch (e: HttpException) {
            } catch (e: Throwable) {
                throwable.value = e
            }
        }
    }
}