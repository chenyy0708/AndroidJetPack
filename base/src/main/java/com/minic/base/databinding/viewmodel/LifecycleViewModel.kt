package com.minic.base.databinding.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
        logD(msg = "${javaClass.simpleName}onCreate")
        this.lifecycleOwner = lifecycleOwner
    }

    @CallSuper
    override fun onStart(lifecycleOwner: LifecycleOwner) {
        logD(msg = "${javaClass.simpleName}onStart")
    }

    @CallSuper
    override fun onResume(lifecycleOwner: LifecycleOwner) {
        logD(msg = "${javaClass.simpleName}onResume")
    }

    @CallSuper
    override fun onPause(lifecycleOwner: LifecycleOwner) {
        logD(msg = "${javaClass.simpleName}onPause")
        viewModelScope
    }

    @CallSuper
    override fun onStop(lifecycleOwner: LifecycleOwner) {
        logD(msg = "${javaClass.simpleName}onStop")
    }

    @CallSuper
    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = null
        logD(msg = "${javaClass.simpleName}onDestroy")
    }

    @CallSuper
    override fun onLifecycleChanged(lifecycleOwner: LifecycleOwner,
                                    event: Lifecycle.Event) {
        logD(msg = "${javaClass.simpleName}onLifecycleChanged")
    }
}
