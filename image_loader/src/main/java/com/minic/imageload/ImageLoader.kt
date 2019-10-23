package com.minic.imageload

import android.content.Context
import android.widget.ImageView


/**
 * 描述: 图片加载契约类
 * 作者: ChenYy
 * 日期: 2019-10-23 16:02
 */
interface ImageLoader {

    fun load(context: Context, url: String, imageView: ImageView)

    fun load(context: Context, url: String, options: ImageLoaderOptions, imageView: ImageView)
}