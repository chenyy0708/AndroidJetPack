package com.minic.kt.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.minic.imageload.ImageFrom
import com.minic.imageload.ImageLoader
import com.minic.imageload.ImageLoaderOptions
import com.minic.kt.R
import com.minic.kt.base.GlideApp


/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2019-10-23 18:44
 */
class GlideImageLoader : ImageLoader {

    /**
     * 加载图片
     *
     * @param context 上下文
     * @param url 图片Url
     * @param imageView ImageView
     */
    override fun load(context: Context, url: String, imageView: ImageView) {
        // 使用默认的 ImageLoaderOptions
        load(context, url, ImageFrom.getDefaultOptions() ?: ImageLoaderOptions(), imageView)
    }

    /**
     * 加载图片
     *
     * @param context 上下文
     * @param url 图片Url
     * @param options 图片加载配置
     * @param imageView ImageView
     */
    override fun load(context: Context, url: String, options: ImageLoaderOptions, imageView: ImageView) {
        GlideApp.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher_round)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher_round)
                .centerCrop()
                .into(imageView)
    }

}