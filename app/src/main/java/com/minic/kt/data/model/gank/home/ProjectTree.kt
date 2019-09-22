package com.minic.kt.data.model.gank.home

data class ProjectTree(
        val courseId: Int,
        val id: Int,
        val visible: Int,
        val order: Int,
        val parentChapterId: Int,
        val userControlSetTop: Boolean,
        val name: String
)