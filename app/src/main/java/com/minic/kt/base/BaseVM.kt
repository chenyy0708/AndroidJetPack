package com.minic.kt.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minic.base.databinding.viewmodel.LifecycleViewModel
import com.minic.kt.data.GankRepository
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
    protected val gankRepository: GankRepository by instance()

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        super.onDestroy(lifecycleOwner)
        viewModelScope.cancel()
    }
}