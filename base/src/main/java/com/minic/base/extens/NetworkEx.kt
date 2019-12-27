package com.minic.base.extens


/**
 * 描述: Retrofit网络请求
 * 作者: ChenYy
 * 日期: 2019-12-27 11:03
 */
//
//fun <T> LifecycleOwner.quickLaunch(block: RequestCarrier<T>.() -> Unit) {
//    val requestCarrier = RequestCarrier<T>()
//    block(requestCarrier)
//    requestCarrier.request?.subscribeOn(Schedulers.io())
//            ?.observeOn(AndroidSchedulers.mainThread())
//            ?.subscribe(Consumer {
//                it?.let { requestCarrier.success?.invoke(it) }
//            }, HttpErrorConsumer {
//                requestCarrier.fail?.invoke(it)
//            })?.addToOwner(this)
//}
//
//class RequestCarrier<T> {
//    var request: Observable<T>? = null
//    var fail: ((throwable: Throwable) -> Unit)? = null
//    var success: ((rsp: T) -> Unit)? = null
//}
//
//fun <T> RequestCarrier<T>.request(block: () -> Observable<T>) {
//    request = block()
//}
//
//fun <T> RequestCarrier<T>.onSuccess(block: (rsp: T) -> Unit) {
//    success = block
//}
//
//fun <T> RequestCarrier<T>.onFail(block: (throwable: Throwable) -> Unit) {
//    fail = block
//}