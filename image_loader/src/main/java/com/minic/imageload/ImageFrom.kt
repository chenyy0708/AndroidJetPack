package com.minic.imageload

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.lifecycle.LiveData

/**
 * 描述: 图片加载配置类
 * 作者: ChenYy
 * 日期: 2019-10-23 16:17
 */
object ImageFrom {

    private var mImageLoader: ImageLoader? = null

    private var options: ImageLoaderOptions? = null

    init {
        // 默认的图片加载配置
        options = ImageLoaderOptions().apply {
        }
    }

    fun getImageLoader(): ImageLoader {
        if(mImageLoader == null) {
            throw Throwable("ImageLoader Can not be null ")
        }
        return mImageLoader!!
    }

    fun setImageLoader(imageLoader: ImageLoader):ImageFrom {
        this.mImageLoader = imageLoader
        return this
    }

    fun setImageLoaderOptions(options: ImageLoaderOptions):ImageFrom {
        this.options = options
        return this
    }

    fun getDefaultOptions():ImageLoaderOptions? {
        return options
    }
}