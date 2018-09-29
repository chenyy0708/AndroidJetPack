package com.qingmei2.rhine.ext.viewmodel

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
//    activity.lifecycle.addObserver(this)
    this.lifecycleOwner = activity
}

fun LifecycleViewModel.addLifecycle(fragment: Fragment) {
//    fragment.lifecycle.addObserver(this)
    this.lifecycleOwner = fragment
}