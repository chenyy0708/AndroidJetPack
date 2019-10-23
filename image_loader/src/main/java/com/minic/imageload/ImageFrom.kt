package com.minic.imageload

import android.content.Context
import android.widget.ImageView

/**
 * 描述: 图片加载配置类
 * 作者: ChenYy
 * 日期: 2019-10-23 16:17
 */
object ImageFrom {

    private var mImageLoader: ImageLoader? = null

    private var options: ImageLoaderOptions? = null

    init {
        options = ImageLoaderOptions().apply {
        }
    }

    fun getImageLoader(): ImageLoader {
        return mImageLoader ?: object : ImageLoader {
            override fun load(context: Context, url: String, imageView: ImageView) {
            }

            override fun load(context: Context, url: String, options: ImageLoaderOptions, imageView: ImageView) {
            }
        }
    }

    fun setImageLoader(imageLoader: ImageLoader) {
        this.mImageLoader = imageLoader
    }
}