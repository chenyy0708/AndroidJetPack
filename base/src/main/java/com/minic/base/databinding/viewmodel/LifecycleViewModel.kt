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


    @CallSuper
    override fun onCreate(lifecycleOwner: LifecycleOwner) {
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
    }

    @CallSuper
    override fun onLifecycleChanged(lifecycleOwner: LifecycleOwner,
                                    event: Lifecycle.Event) {
    }
}
