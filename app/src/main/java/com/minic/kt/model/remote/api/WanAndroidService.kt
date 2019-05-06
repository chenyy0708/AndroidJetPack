package com.minic.kt.model.remote.api

import com.minic.base.net.UrlConstant
import com.minic.kt.model.data.BResponse
import com.minic.kt.model.data.Chapters
import kotlinx.coroutines.Deferred
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:33
 * @description  :豆瓣Api
 * @github       :https://github.com/chenyy0708
 */
interface WanAndroidService {
    /**
     * 公众号列表
     */
    @Headers(RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlConstant.WAN_ANDROID)
    @GET("wxarticle/chapters/json")
    fun chaptersAsync(): Deferred<BResponse<List<Chapters>>>
}