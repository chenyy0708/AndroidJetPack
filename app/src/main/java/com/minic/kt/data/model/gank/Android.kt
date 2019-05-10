package com.minic.kt.data.model.gank

/**
 * @ClassName: Android
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-09 09:58
 */

data class Android(
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