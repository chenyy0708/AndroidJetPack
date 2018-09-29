package com.cyy.base.base.viewmodel

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import com.qingmei2.rhine.base.viewmodel.IViewModel

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
