package com.cyy.kt.base

import com.cyy.base.base.BaseApp
import com.cyy.kt.net.UrlConstanct
import me.jessyan.retrofiturlmanager.RetrofitUrlManager

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/13:46
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class App : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        RetrofitUrlManager.getInstance().putDomain(UrlConstanct.DOUBAN, UrlConstanct.DOUBAN_URL)
        RetrofitUrlManager.getInstance().putDomain(UrlConstanct.GANK, UrlConstanct.GANK_URL)
    }
}