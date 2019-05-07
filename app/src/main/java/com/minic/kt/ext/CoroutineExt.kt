package com.minic.kt.ext

import com.minic.base.net.exception.CException
import com.minic.kt.model.data.BResponse
import kotlinx.coroutines.Deferred
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * @ClassName: CoroutineExt
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-06 17:50
 */

//@Throws(Exception::class)
//suspend fun <T> Deferred<BResponse<T>>.awaitResponse(catchBlock: suspend (Throwable) -> Unit): T? {
//    var response: BResponse<T>? = null
//    try {
//        delay(3000L)
//        response = await()
//        if (0 == response.errorCode) {
//            return response.data
//        } else {
//            catchBlock(CException(response.errorMsg))
//        }
//    } catch (e: Throwable) {
//        catchBlock(e)
//    }
//    return response?.data
//}

suspend fun <T> Deferred<BResponse<T>>.awaitResponse(catchBlock: suspend (Throwable) -> Unit): T? {
    var response: BResponse<T>? = null
    try {
        response = await()
    } catch (e: Throwable) {
        catchBlock(e)
        return null
    }
    return suspendCoroutine<T> { cont ->
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
}

