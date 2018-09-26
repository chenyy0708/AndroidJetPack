package com.cyy.base.rx

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:07
 * @description  :线程切换
 * @github       :https://github.com/chenyy0708
 */

fun <T> applySchedulers(): ObservableTransformer<T, T> {
    return ObservableTransformer { observable ->
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
