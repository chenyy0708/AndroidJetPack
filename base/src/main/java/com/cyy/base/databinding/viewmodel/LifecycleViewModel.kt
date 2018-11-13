package com.cyy.base.databinding.viewmodel

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import com.cyy.base.extens.logD

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
