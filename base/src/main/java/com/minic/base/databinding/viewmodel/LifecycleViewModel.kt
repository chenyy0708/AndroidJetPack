package com.minic.base.databinding.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

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
    }

    @CallSuper
    override fun onStart(lifecycleOwner: LifecycleOwner) {
    }

    @CallSuper
    override fun onResume(lifecycleOwner: LifecycleOwner) {
    }

    @CallSuper
    override fun onPause(lifecycleOwner: LifecycleOwner) {
    }

    @CallSuper
    override fun onStop(lifecycleOwner: LifecycleOwner) {
    }

    @CallSuper
    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = null
    }

    @CallSuper
    override fun onLifecycleChanged(lifecycleOwner: LifecycleOwner,
                                    event: Lifecycle.Event) {
    }
}
