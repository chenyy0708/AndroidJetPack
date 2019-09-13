package com.minic.kt.data.model.gank.home

data class Article(
        val curPage: Int,
        var pageCount: Int,
        val total: Int,
        val offset: Int,
        val datas: MutableList<ArticleData>
)



data class TagData(
        val name: String,
        val url: String
)