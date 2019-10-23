package com.minic.imageload

import android.content.Context
import android.widget.ImageView


/**
 * 描述: ImageView加载Url扩展函数
 * 作者: ChenYy
 * 日期: 2019-10-23 18:52
 */

fun ImageView.loadIV(url: String) {
    ImageFrom.getImageLoader().load(context, url, this)
}

fun ImageView.loadIV(url: String, options: ImageLoaderOptions) {
    ImageFrom.getImageLoader().load(context, url, options, this)
}