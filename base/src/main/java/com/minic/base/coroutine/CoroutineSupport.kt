package com.minic.base.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

/**
 * @ClassName: CoroutineSupport
 * @Description:统一管理协程任务
 * @Author: ChenYy
 * @Date: 2019-05-07 09:53
 */
class CoroutineSupport : CoroutineScope {

    private val job: Job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + job

    fun cancelAllJob() = job.cancel()
}