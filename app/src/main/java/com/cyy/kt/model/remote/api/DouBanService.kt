package com.cyy.kt.model.remote.api

import com.cyy.base.net.UrlConstanct
import com.cyy.kt.model.data.Book
import io.reactivex.Flowable
import io.reactivex.Observable
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:33
 * @description  :豆瓣Api
 * @github       :https://github.com/chenyy0708
 */
interface DouBanService {
    @Headers(RetrofitUrlManager.DOMAIN_NAME_HEADER + UrlConstanct.DOUBAN)
    @GET("v2/book/1220562")
    fun getDouBanBook(): Flowable<Book>
}