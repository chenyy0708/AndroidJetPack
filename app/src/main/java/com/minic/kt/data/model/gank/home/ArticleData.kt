package com.minic.kt.data.model.gank.home

data class ArticleData(
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