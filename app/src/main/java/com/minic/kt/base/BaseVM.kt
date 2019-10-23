package com.minic.kt.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.minic.base.databinding.viewmodel.LifecycleViewModel


open class BaseVM : LifecycleViewModel() {
    /**
     * throwable
     */
    open val throwable = MutableLiveData<Throwable>()


    protected var isInit = false

    override fun onStart(lifecycleOwner: LifecycleOwner) {
        super.onStart(lifecycleOwner)
        isInit = true
    }

    override fun onCleared() {
        super.onCleared()
        isInit = false
    }
}