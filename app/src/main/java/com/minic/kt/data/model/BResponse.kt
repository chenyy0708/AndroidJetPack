package com.minic.kt.data.model

/**
 * @ClassName: BResponse
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-06 18:03
 */
data class BResponse<T>(
        val `data`: T,
        val errorCode: Int,
        val errorMsg: String
)