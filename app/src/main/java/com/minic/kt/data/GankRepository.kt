package com.minic.kt.data

import com.minic.kt.data.api.GankService
import com.minic.kt.data.model.BResponse
import com.minic.kt.data.model.Chapters
import kotlinx.coroutines.Deferred

/**
 * @author       :ChenYangYi
 * @date         :2019-5-8 21:57:32
 * @description  :Gank
 * @github       :https://github.com/chenyy0708
 */
class GankRepository constructor(private val gankService: GankService) {
    /**
     * 文章列表
     */
    fun chaptersAsync(): Deferred<BResponse<List<Chapters>>> = gankService.chaptersAsync()
}