package com.cyy.base.net

import android.arch.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableObserver

/**
 * @author       :ChenYangYi
 * @date         :2018/10/08/16:11
 * @description  :统一处理错误Throwable回调到UI层
 * @github       :https://github.com/chenyy0708
 */
abstract class BaseObserver<T>(private val throwableData: MutableLiveData<Throwable>) : DisposableObserver<T>() {
    override fun onComplete() {
    }

    override fun onError(throwable: Throwable) {
        throwableData.value = throwable
    }
}