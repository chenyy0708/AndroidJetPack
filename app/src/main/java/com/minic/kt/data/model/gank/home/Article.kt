package com.minic.kt.data.model.gank.home

data class Article(
        val curPage: Int,
        val pageCount: Int,
        val total: Int,
        val offset: Int,
        val datas: MutableList<AcrticleData>
)

data class AcrticleData(
        val apkLink: String,
        val author: String,
        val chapterName: String,
        val collect: Boolean,
        val desc: String,
        val link: String,
        val niceDate: String,
        val publishTime: String,
        val superChapterName: String,
        val tags: MutableList<TagData>,
        val title: String,
        val visible: Int,
        val zan: Int,
        val userId: Int
)

data class TagData(
        val name: String,
        val url: String
)