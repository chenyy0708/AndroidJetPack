package com.minic.imageload

import android.content.Context
import android.widget.ImageView


/**
 * 描述: 图片加载契约类
 * 作者: ChenYy
 * 日期: 2019-10-23 16:02
 */
interface ImageLoader {

    /**
     * 加载图片
     *
     * @param context 上下文
     * @param url 图片Url
     * @param imageView ImageView
     */
    fun load(context: Context, url: String, imageView: ImageView)

    /**
     * 加载图片
     *
     * @param context 上下文
     * @param url 图片Url
     * @param options 图片加载配置
     * @param imageView ImageView
     */
    fun load(context: Context, url: String, options: ImageLoaderOptions, imageView: ImageView)
}