package com.minic.imageload


/**
 * 描述: 下载进度
 * 作者: ChenYy
 * 日期: 2019-10-25 11:36
 */

data class ProgressDownLoad<T>(
        val downLoad: T,
        val progress: Float
)