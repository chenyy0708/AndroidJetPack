package com.minic.kt.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minic.base.databinding.viewmodel.LifecycleViewModel
import com.minic.base.extens.logD
import com.minic.kt.data.WAndroidRepository
import kotlinx.coroutines.cancel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

open class BaseVM : LifecycleViewModel(), KodeinAware {
    /**
     * 全局Kodein
     */
    override val kodein: Kodein = App.INSTANCE.kodein

    /**
     * throwable
     */
    open val throwable = MutableLiveData<Throwable>()

    /**
     * Application中注入的Repository
     */
    protected val repository: WAndroidRepository by instance()

    protected var isInit = false

    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        super.onCreate(lifecycleOwner)
    }

    override fun onStart(lifecycleOwner: LifecycleOwner) {
        super.onStart(lifecycleOwner)
        isInit = true
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
        isInit = false
    }
}