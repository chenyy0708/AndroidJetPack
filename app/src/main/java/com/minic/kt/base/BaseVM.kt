package com.minic.kt.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.minic.base.databinding.viewmodel.LifecycleViewModel
import com.minic.kt.model.remote.api.WanAndroidService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

open class BaseVM : LifecycleViewModel(), KodeinAware, CoroutineScope by CoroutineScope(Dispatchers.Default) {
    /**
     * 全局Kodein
     */
    override val kodein: Kodein = App.INSTANCE.kodein

    /**
     * 错误
     */
    open val throwable = MutableLiveData<Throwable>()

    /**
     * Application中注入的ApiService
     */
    protected val wanAndroidService: WanAndroidService by instance()

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        super.onDestroy(lifecycleOwner)
        cancel()
    }
}