package com.minic.kt.data.api

import com.minic.base.net.UrlConstant
import com.minic.kt.data.model.BResponse
import com.minic.kt.data.model.gank.home.BannerData
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:33
 * @description  :GankApi
 * @github       :https://github.com/chenyy0708
 */
interface WAndroidService {
    /**
     * 公众号列表
     */
    @Headers(RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlConstant.WAN_ANDROID)
    @GET("banner/json")
    suspend fun banners(): BResponse<MutableList<BannerData>>
}