package com.cyy.base.net

import android.arch.lifecycle.MutableLiveData
import com.cyy.base.extens.logD
import io.reactivex.subscribers.DisposableSubscriber
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * @author       :ChenYangYi
 * @date         :2018/10/08/16:11
 * @description  :统一处理错误Throwable回调到UI层
 * @github       :https://github.com/chenyy0708
 */
abstract class BaseObserver<T>(private val throwableData: MutableLiveData<Throwable>) : DisposableSubscriber<T>() {

    override fun onNext(t: T) {
       logD("成功")
    }

//    override fun onSubscribe(s: Subscription?) {
//        logD("onSubscribe")
//    }

    override fun onComplete() {
        logD("onComplete")
    }

    override fun onError(throwable: Throwable) {
        logD("onError")
        throwableData.value = throwable
    }
}