package com.minic.imageload

import android.widget.ImageView
import com.minic.imageload.ImageLoaderOptions.Companion.NORMAL_VALUE


/**
 * 描述: ImageView加载Url扩展函数
 * 作者: ChenYy
 * 日期: 2019-10-23 18:52
 */

fun ImageView.loadIV(url: String) {
    ImageFrom.getImageLoader().load(context, url, ImageFrom.getDefaultOptions()
            ?: ImageLoaderOptions(), this)
}

fun ImageView.loadIV(url: String,
                     placeHolder: Int = NORMAL_VALUE,
                     radius: Int = NORMAL_VALUE,
                     isSkipMemoryCache: Boolean = false,
                     isSkipDiskCache: Boolean = false) {
    ImageFrom.getImageLoader().load(context, url, ImageLoaderOptions().apply {
        this.placeHolder = placeHolder
        this.radius = radius
        this.isSkipMemoryCache = isSkipMemoryCache
        this.isSkipDiskCache = isSkipDiskCache
    }, this)
}
