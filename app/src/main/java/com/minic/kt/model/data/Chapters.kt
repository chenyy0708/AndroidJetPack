package com.minic.kt.model.data

/**
 * @ClassName: 公众号列表
 * @Description:
 * @Author: ChenYy
 * @Date: 2019/3/20 下午5:36
 */

data class Chapters(
        val `data`: List<Data>,
        val errorCode: Int,
        val errorMsg: String
)

data class Data(
        val children: List<Any>,
        val courseId: Int,
        val id: Int,
        val name: String,
        val order: Int,
        val parentChapterId: Int,
        val userControlSetTop: Boolean,
        val visible: Int
)