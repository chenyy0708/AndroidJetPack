package com.cyy.base.extens

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.cyy.base.base.viewmodel.LifecycleViewModel

/**
 * @author       :ChenYangYi
 * @date         :2018/07/24/14:38
 * @description  :扩展LifecycleViewModel可以直接绑定Activity和Fragment中的Lifecycle
 * @github       :https://github.com/chenyy0708
 */


fun LifecycleViewModel.addLifecycle(activity: FragmentActivity) {
    this.lifecycleOwner = activity
}

fun LifecycleViewModel.addLifecycle(fragment: Fragment) {
    this.lifecycleOwner = fragment
}

fun <T : LifecycleViewModel> FragmentActivity.viewModel(modelClass: Class<T>) =
        ViewModelProviders.of(this).get(modelClass).also {
            lifecycle.addObserver(it)
        }

fun <T : LifecycleViewModel> Fragment.viewModel(modelClass: Class<T>) =
        ViewModelProviders.of(activity!!).get(modelClass).also {
            lifecycle.addObserver(it)
        }
