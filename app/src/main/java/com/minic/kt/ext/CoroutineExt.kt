package com.minic.kt.ext

import com.minic.base.extens.logD
import com.minic.base.net.exception.CException
import com.minic.kt.model.data.BResponse
import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * @ClassName: CoroutineExt
 * @Description:网络请求返回结果统一处理
 * @Author: ChenYy
 * @Date: 2019-05-06 17:50
 */
@ObsoleteCoroutinesApi
suspend fun <T> Deferred<BResponse<T>>.awaitResponse(catchBlock: suspend (Throwable) -> Unit = {}): T? {
    val response: BResponse<T>?
    val result: T?
    try {
        logD("HomeVM", "awaitResponse:${Thread.currentThread().name}")
        response = await()
        result = suspendCancellableCoroutine<T> { cont ->
            if (null == response) {
                cont.resumeWithException(CException("No data"))
            } else {
                if (response.errorCode == 0) {
                    cont.resume(response.data)
                } else {
                    cont.resumeWithException(CException(response.errorMsg))
                }
            }
        }
    } catch (e: Throwable) {
        catchBlock(e)
        return null
    }
    return result
}

