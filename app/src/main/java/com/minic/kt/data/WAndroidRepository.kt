package com.minic.kt.data

import com.minic.kt.data.api.WAndroidService
import com.minic.kt.data.model.BResponse
import com.minic.kt.data.model.gank.PagingData
import com.minic.kt.data.model.gank.home.Article
import com.minic.kt.data.model.gank.home.ArticleData
import com.minic.kt.data.model.gank.home.BannerData
import com.minic.kt.data.model.gank.home.ProjectTree

/**
 * @author       :ChenYangYi
 * @date         :2019-5-8 21:57:32
 * @description  :Gank
 * @github       :https://github.com/chenyy0708
 */
class WAndroidRepository constructor(private val service: WAndroidService) {
    suspend fun banners(): BResponse<MutableList<BannerData>> = service.banners()
    suspend fun article(page: Int): BResponse<Article> = service.article(page)
    suspend fun articleTop(): BResponse<MutableList<ArticleData>> = service.articleTop()
    suspend fun projectTree(): BResponse<MutableList<ProjectTree>> = service.projectTree()
    suspend fun projectList(page: Int, cid: Int): BResponse<PagingData<ArticleData>> = service.projectList(page, cid)
}