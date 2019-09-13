package com.minic.kt.data.api

import com.minic.base.net.UrlConstant
import com.minic.kt.data.model.BResponse
import com.minic.kt.data.model.gank.home.Article
import com.minic.kt.data.model.gank.home.BannerData
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

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
}