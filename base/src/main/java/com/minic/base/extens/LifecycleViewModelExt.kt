package com.minic.base.extens

/**
 * @author       :ChenYangYi
 * @date         :2018/09/29/15:30
 * @description  :LifecycleViewModel 扩展函数
 * @github       :https://github.com/chenyy0708
 */


/**
 * 扩展Observable 绑定LifecycleViewModel
 */
//fun <T> Observable<T>.bindLifecycle(lifecycleViewModel: LifecycleViewModel): ObservableSubscribeProxy<T> =
//        bindLifeCycle(lifecycleViewModel.lifecycleOwner
//                ?: throw throwableWhenLifecycleOwnerIsNull(lifecycleViewModel))
//
//fun <T> Flowable<T>.bindLifecycle(lifecycleViewModel: LifecycleViewModel): FlowableSubscribeProxy<T> =
//        bindLifeCycle(lifecycleViewModel.lifecycleOwner
//                ?: throw throwableWhenLifecycleOwnerIsNull(lifecycleViewModel))


//private fun throwableWhenLifecycleOwnerIsNull(viewModel: LifecycleViewModel): NullPointerException =
//        NullPointerException("$viewModel's lifecycleOwner is null.")
