package com.minic.kt.data

import com.minic.kt.data.api.WAndroidService
import com.minic.kt.data.model.BResponse
import com.minic.kt.data.model.gank.home.BannerData

/**
 * @author       :ChenYangYi
 * @date         :2019-5-8 21:57:32
 * @description  :Gank
 * @github       :https://github.com/chenyy0708
 */
class WAndroidRepository constructor(private val gankService: WAndroidService) {
    /**
     * Banner
     */
    suspend fun banners(): BResponse<MutableList<BannerData>> = gankService.banners()
}