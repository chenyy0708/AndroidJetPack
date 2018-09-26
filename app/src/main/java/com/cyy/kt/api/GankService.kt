package com.cyy.kt.api

import com.cyy.kt.bean.MeizhiData
import com.cyy.kt.net.UrlConstanct
import io.reactivex.Observable
import me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:33
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
interface GankService {
    @Headers(DOMAIN_NAME_HEADER + UrlConstanct.GANK)
    @GET("api/data/福利/10/1")
    fun getMeiZhi(): Observable<MeizhiData>
}