package com.minic.kt.data.model.gank.home

data class BannerData(
        val desc: String,
        val id: Long,
        val imagePath: String,
        val isVisible: Int,
        val order: Int,
        val title: String,
        val type: Int,
        val url: String
)