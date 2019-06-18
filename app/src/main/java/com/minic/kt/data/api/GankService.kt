package com.minic.kt.data.api

import com.minic.base.net.UrlConstant
import com.minic.kt.data.model.BResponse
import com.minic.kt.data.model.BV2Response
import com.minic.kt.data.model.Chapters
import com.minic.kt.data.model.gank.Android
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
interface GankService {
    /**
     * 公众号列表
     */
    @Headers(RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlConstant.WAN_ANDROID)
    @GET("wxarticle/chapters/json")
    suspend fun chaptersAsync(): BResponse<List<Chapters>>

    /**
     * Android列表
     */
    @Headers(RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlConstant.GANK_IO)
    @GET("data/{type}/{rows}/{page}")
    suspend fun androidListAsync(@Path("page") page: Int, @Path("rows") rows: Int, @Path("type") type: String):
            BV2Response<List<Android>>
}