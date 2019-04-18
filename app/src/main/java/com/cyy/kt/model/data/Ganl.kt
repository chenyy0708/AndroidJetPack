package com.cyy.kt.model.data

/**
 * @ClassName: Ganl
 * @Description:
 * @Author: ChenYy
 * @Date: 2019/3/20 下午5:36
 */
data class Gank(
        val error: Boolean,
        val results: List<Result>
)

data class Result(
        val _id: String,
        val createdAt: String,
        val desc: String,
        val images: List<String>,
        val publishedAt: String,
        val source: String,
        val type: String,
        val url: String,
        val used: Boolean,
        val who: String
)