package com.minic.kt.data.api

import com.minic.base.net.UrlConstant
import com.minic.kt.data.model.BResponse
import com.minic.kt.data.model.gank.PagingData
import com.minic.kt.data.model.gank.home.Article
import com.minic.kt.data.model.gank.home.ArticleData
import com.minic.kt.data.model.gank.home.BannerData
import com.minic.kt.data.model.gank.home.ProjectTree
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:33
 * @description  :GankApi
 * @github       :https://github.com/chenyy0708
 */
interface WAndroidService {
    /**
     * Banner
     */
    @Headers(RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlConstant.WAN_ANDROID)
    @GET("banner/json")
    suspend fun banners(): BResponse<MutableList<BannerData>>

    /**
     * 文章列表
     */
    @Headers(RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlConstant.WAN_ANDROID)
    @GET("article/list/{page}/json")
    suspend fun article(@Path("page") page: Int): BResponse<Article>

    /**
     * 置顶文章
     */
    @Headers(RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlConstant.WAN_ANDROID)
    @GET("article/top/json")
    suspend fun articleTop(): BResponse<MutableList<ArticleData>>

    /**
     * 项目分类
     */
    @Headers(RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlConstant.WAN_ANDROID)
    @GET("project/tree/json")
    suspend fun projectTree(): BResponse<MutableList<ProjectTree>>

    /**
     * 项目列表数据
     */
    @Headers(RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlConstant.WAN_ANDROID)
    @GET("project/list/{page}/json")
    suspend fun projectList(@Path("page") page: Int, @Query("cid") cid: Int): BResponse<PagingData<ArticleData>>
}