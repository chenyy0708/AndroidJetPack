package com.minic.base.net.source

import androidx.lifecycle.LifecycleObserver


/**
 * 描述: 通用请求数据，扩展网络和本地
 * 作者: ChenYy
 * 日期: 2019-11-28 16:43
 */
interface ISourceRequest<T>: LifecycleObserver {
    fun getResponse()
    fun refreshData()
}