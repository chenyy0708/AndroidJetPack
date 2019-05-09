package com.minic.kt.data.model

/**
 * @ClassName: BResponse
 * @Description:Gank Api 封装返回参数
 * @Author: ChenYy
 * @Date: 2019-05-06 18:03
 */
data class BV2Response<T>(
        val `results`: T,
        val error: Boolean
)