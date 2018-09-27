package com.cyy.kt.api

import com.cyy.kt.model.data.DouBanBook
import com.cyy.kt.net.UrlConstanct
import io.reactivex.Observable
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:33
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
interface DouBanService {
    @Headers(RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlConstanct.DOUBAN)
    @GET("v2/book/1220562")
    fun getDouBanBook(): Observable<DouBanBook>
}