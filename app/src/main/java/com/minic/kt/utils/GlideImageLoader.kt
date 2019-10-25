package com.minic.kt.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.minic.imageload.ImageFrom
import com.minic.imageload.ImageLoader
import com.minic.imageload.ImageLoaderOptions
import com.minic.imageload.ProgressDownLoad
import com.minic.kt.R
import com.minic.kt.base.GlideApp


/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2019-10-23 18:44
 */
class GlideImageLoader : ImageLoader {
    override fun <T> loadProgress(context: Context, url: String): LiveData<ProgressDownLoad<T>> {
        return MutableLiveData<ProgressDownLoad<T>>()
    }

    override fun loadBitmap(context: Context, url: String): LiveData<Bitmap> {
        return loadBitmap(context, url, ImageLoaderOptions())
    }

    override fun loadBitmap(context: Context, url: String, options: ImageLoaderOptions): LiveData<Bitmap> {
        val liveData = MutableLiveData<Bitmap>()
        GlideApp.with(context)
                .asBitmap()
                .load(url)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onLoadCleared(placeholder: Drawable?) {
                    }

                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        liveData.value = resource
                    }

                })
        return liveData
    }

    override fun load(context: Context, url: String, imageView: ImageView) {
        // 使用默认的 ImageLoaderOptions
        load(context, url, ImageFrom.getDefaultOptions() ?: ImageLoaderOptions(), imageView)
    }

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