package com.cyy.kt.net

import io.reactivex.observers.DisposableObserver

/**
 * @author       :ChenYangYi
 * @date         :2018/10/08/16:11
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
abstract class BaseObserver<T> : DisposableObserver<T>() {
    override fun onComplete() {
    }
}