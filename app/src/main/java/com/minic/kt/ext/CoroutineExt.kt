package com.minic.kt.ext

import com.minic.base.net.exception.CException
import com.minic.kt.model.data.BResponse
import kotlinx.coroutines.Deferred

/**
 * @ClassName: CoroutineExt
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-06 17:50
 */

@Throws(Exception::class)
suspend fun <T> Deferred<BResponse<T>>.awaitResponse(exception: (Throwable) -> Unit): T? {
    var response: BResponse<T>? = null
    try {
        response = await()
        if (0 == response.errorCode) {
            return response.data
        } else {
            exception.invoke(CException(response.errorMsg))
        }
    } catch (e: Throwable) {
        exception.invoke(e)
    }
    return response?.data
}

