package com.minic.kt.ext

import com.minic.base.net.exception.CException
import com.minic.kt.data.model.BResponse
import com.minic.kt.data.model.BV2Response
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * @ClassName: CoroutineExt
 * @Description:网络请求返回结果统一处理
 * @Author: ChenYy
 * @Date: 2019-05-06 17:50
 */
suspend fun <T> Deferred<BResponse<T>>.awaitResponse(catchBlock: suspend (Throwable) -> Unit = {}): T? {
    var result: T? = null
    try {
        val response = await()
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
        return result
    }
    return result
}

suspend fun <T> Deferred<BV2Response<T>>.awaitV2Response(catchBlock: suspend (Throwable) -> Unit = {}): T? {
    var result: T? = null
    try {
        val response = await()
        result = suspendCancellableCoroutine<T> { cont ->
            if (null == response) {
                cont.resumeWithException(CException("No data"))
            } else {
                if (!response.error) {
                    cont.resume(response.`results`)
                } else {
                    cont.resumeWithException(CException("Error"))
                }
            }
        }
    } catch (e: Throwable) {
        catchBlock(e)
        return result
    }
    return result
}

