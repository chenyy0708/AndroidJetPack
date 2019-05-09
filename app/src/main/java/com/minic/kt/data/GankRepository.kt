package com.minic.kt.data

import com.minic.kt.data.api.GankService
import com.minic.kt.data.model.BResponse
import com.minic.kt.data.model.BV2Response
import com.minic.kt.data.model.Chapters
import com.minic.kt.data.model.gank.Android
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

    /**
     * 干货网站数据
     */
    fun androidListAsync(page: Int, rows: Int): Deferred<BV2Response<List<Android>>> = gankService.androidListAsync(page, rows)
}