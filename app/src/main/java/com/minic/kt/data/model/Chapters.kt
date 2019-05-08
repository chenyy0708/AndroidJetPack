package com.minic.kt.data.model

/**
 * @ClassName: 公众号列表
 * @Description:
 * @Author: ChenYy
 * @Date: 2019/3/20 下午5:36
 */
data class Chapters(
        val children: List<Any>,
        val courseId: Int,
        val id: Int,
        val name: String,
        val order: Int,
        val parentChapterId: Int,
        val userControlSetTop: Boolean,
        val visible: Int
)