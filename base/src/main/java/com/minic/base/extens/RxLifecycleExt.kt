package com.minic.base.extens

/**
 * @author       :ChenYangYi
 * @date         :2018/09/29/09:44
 * @description  :Rxjava 一些扩展函数
 * @github       :https://github.com/chenyy0708
 */
//
///**
// * 延时执行任务--扩展函数
// */
//fun <T> Observable<T>.async(withDelay: Long = 0): Observable<T> =
//        this.subscribeOn(Schedulers.io()).delay(withDelay, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread())
//
///**
// * 延时执行任务--扩展函数
// */
//fun <T> Flowable<T>.async(withDelay: Long = 0): Flowable<T> =
//        this.subscribeOn(Schedulers.io()).delay(withDelay, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread())
//
///**
// * 延时执行任务--扩展函数
// */
//fun <T> Single<T>.async(withDelay: Long = 0): Single<T> =
//        this.subscribeOn(Schedulers.io()).delay(withDelay, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread())
//
///**
// * 线程转换--扩展函数
// */
//fun <T> Observable<T>.applySchedulers(): Observable<T> {
//    return this.compose { observable ->
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//    }
//}
//
//
///**
// * 线程转换--扩展函数
// */
//fun <T> Flowable<T>.applySchedulers(): Flowable<T> {
//    return this.compose { observable ->
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//    }
//}
//
///**
// *
// * 线程切换 + 自动绑定Activity/Fragment生命周期取消订阅
// */
//fun <T> Observable<T>.bindLifeCycle(owner: LifecycleOwner): ObservableSubscribeProxy<T> =
//        this.applySchedulers().`as`(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(owner,Lifecycle.Event.ON_DESTROY )))
//
///**
// *
// * 线程切换 + 自动绑定Activity/Fragment生命周期取消订阅
// */
//fun <T> Flowable<T>.bindLifeCycle(owner: LifecycleOwner): FlowableSubscribeProxy<T> =
//        this.applySchedulers().`as`(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(owner, Lifecycle.Event.ON_DESTROY)))