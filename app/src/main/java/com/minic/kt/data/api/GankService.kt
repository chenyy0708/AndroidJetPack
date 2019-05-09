package com.minic.kt.data.api

import com.minic.base.net.UrlConstant
import com.minic.kt.data.model.BResponse
import com.minic.kt.data.model.BV2Response
import com.minic.kt.data.model.Chapters
import com.minic.kt.data.model.gank.Android
import kotlinx.coroutines.Deferred
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
    fun chaptersAsync(): Deferred<BResponse<List<Chapters>>>

    /**
     * Android列表
     */
    @Headers(RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlConstant.GANK_IO)
    @GET("data/Android/{rows}/{page}")
    fun androidListAsync(@Path("page") page: Int, @Path("rows") rows: Int):
            Deferred<BV2Response<List<Android>>>
}