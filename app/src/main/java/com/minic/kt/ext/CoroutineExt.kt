package com.minic.kt.ext

import com.minic.base.net.exception.CException
import com.minic.kt.model.data.BResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * @ClassName: CoroutineExt
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-06 17:50
 */

@Throws(Exception::class)
suspend fun <T> Deferred<BResponse<T>>.awaitResponse(exception: (Throwable) -> Unit): T {
    var response: BResponse<T>? = await()
    return suspendCancellableCoroutine { coroutine ->
        try {
            if (response?.errorCode == 0) {
                coroutine.resume(response.data)
            } else {
                exception?.invoke(CException(response!!.errorMsg))
            }
        } catch (e: Throwable) {
            exception?.invoke(e)
        }
    }
}

