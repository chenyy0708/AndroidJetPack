package com.minic.base.net

import androidx.lifecycle.MutableLiveData

/**
 * @author       :ChenYangYi
 * @date         :2018/10/08/16:11
 * @description  :统一处理错误Throwable回调到UI层
 * @github       :https://github.com/chenyy0708
 */
//abstract class BaseObserver<T>(private val throwableData: MutableLiveData<Throwable>) : DisposableSubscriber<T>() {
//
//    override fun onComplete() {
//    }
//
//    override fun onError(throwable: Throwable) {
//        throwableData.value = throwable
//    }
//}