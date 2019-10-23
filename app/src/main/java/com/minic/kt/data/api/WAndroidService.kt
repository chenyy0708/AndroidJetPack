package com.minic.kt.data.api

import com.minic.kt.data.model.BResponse
import com.minic.kt.data.model.gank.PagingData
import com.minic.kt.data.model.gank.home.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:33
 * @description  :WAndroidService
 * @github       :https://github.com/chenyy0708
 */
interface WAndroidService {
    /**
     * Banner
     */
    @GET("banner/json")
    suspend fun banners(): BResponse<MutableList<BannerData>>

    /**
     * 文章列表
     */
    @GET("article/list/{page}/json")
    suspend fun article(@Path("page") page: Int): BResponse<Article>

    /**
     * 置顶文章
     */
    @GET("article/top/json")
    suspend fun articleTop(): BResponse<MutableList<ArticleData>>

    /**
     * 项目分类
     */
    @GET("project/tree/json")
    suspend fun projectTree(): BResponse<MutableList<ProjectTree>>

    /**
     * 项目列表数据
     */
    @GET("project/list/{page}/json")
    suspend fun projectList(@Path("page") page: Int, @Query("cid") cid: Int): BResponse<PagingData<ArticleData>>

    /**
     * 体系首页
     */
    @GET("tree/json")
    suspend fun systemTree(): BResponse<MutableList<SystemTree>>
}