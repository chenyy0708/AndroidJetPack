package com.minic.kt.data.model.gank.home

/**
 * @ClassName: SystemTree
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-09-27 15:07
 */
data class SystemTree(
        val courseId: Int,
        val id: Int,
        val order: Int,
        val parentChapterId: Int,
        val visible: Int,
        val userControlSetTop: Boolean,
        val name: String,
        val children: MutableList<TreeData>
)

data class TreeData(
        val name: String,
        val courseId: Int,
        val id: Int,
        val parentChapterId: Int
)