package com.minic.base.extens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.minic.base.databinding.viewmodel.LifecycleViewModel

/**
 * @author       :ChenYangYi
 * @date         :2018/07/24/14:38
 * @description  :扩展LifecycleViewModel可以直接绑定Activity和Fragment中的Lifecycle
 * @github       :https://github.com/chenyy0708
 */

fun <T : LifecycleViewModel> FragmentActivity.viewModel(modelClass: Class<T>) =
        ViewModelProviders.of(this).get(modelClass).also {
            it.lifecycleOwner = this
            lifecycle.addObserver(it)
        }

fun <T : LifecycleViewModel> Fragment.viewModel(modelClass: Class<T>) =
        ViewModelProviders.of(activity!!).get(modelClass).also {
            it.lifecycleOwner = this
            lifecycle.addObserver(it)
        }
