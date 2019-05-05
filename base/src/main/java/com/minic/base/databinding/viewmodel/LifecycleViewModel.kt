package com.minic.base.databinding.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.annotation.CallSuper
import com.minic.base.extens.logD

/**
 * @author       :ChenYangYi
 * @date         :2018/09/29/15:28
 * @description  :生命周期绑定ViewModel
 * @github       :https://github.com/chenyy0708
 */

open class LifecycleViewModel : ViewModel(), IViewModel {

    var lifecycleOwner: LifecycleOwner? = null

    @CallSuper
    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner
        logD("onCreate")
    }

    @CallSuper
    override fun onStart(lifecycleOwner: LifecycleOwner) {
        logD("onStart")
    }

    @CallSuper
    override fun onResume(lifecycleOwner: LifecycleOwner) {
        logD("onResume")
    }

    @CallSuper
    override fun onPause(lifecycleOwner: LifecycleOwner) {
        logD("onPause")
    }

    @CallSuper
    override fun onStop(lifecycleOwner: LifecycleOwner) {
        logD("onStop")
    }

    @CallSuper
    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        logD("onDestroy")
        this.lifecycleOwner = null
    }

    @CallSuper
    override fun onLifecycleChanged(lifecycleOwner: LifecycleOwner,
                                    event: Lifecycle.Event) {
        logD("onLifecycleChanged")
    }
}
