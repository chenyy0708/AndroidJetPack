package com.minic.kt.ext

import com.minic.base.net.exception.CException
import com.minic.kt.data.model.BResponse
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * @ClassName: CoroutineExt
 * @Description:网络请求返回结果统一处理
 * @Author: ChenYy
 * @Date: 2019-05-06 17:50
 */
suspend fun <T> BResponse<T>.awaitResponse(catchBlock: suspend (Throwable) -> Unit = {}): T? {
    var result: T? = null
    try {
        result = suspendCancellableCoroutine<T> { cont ->
            if (null == this) {
                cont.resumeWithException(CException("No data"))
            } else {
                if (this.errorCode == 0) {
                    cont.resume(this.data)
                } else {
                    cont.resumeWithException(CException(this.errorMsg))
                }
            }
        }
    } catch (e: Throwable) {
        catchBlock(e)
        return result
    }
    return result
}

