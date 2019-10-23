package com.minic.kt.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
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
    override fun load(context: Context, url: String, imageView: ImageView) {
        GlideApp.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher_round)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher_round)
                .centerCrop()
                .into(imageView)
    }

    override fun load(context: Context, url: String, options: ImageLoaderOptions, imageView: ImageView) {
    }
}