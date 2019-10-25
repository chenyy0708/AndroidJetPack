package com.minic.kt.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.minic.imageload.ImageFrom
import com.minic.imageload.ImageLoader
import com.minic.imageload.ImageLoaderOptions
import com.minic.imageload.ProgressDownLoad
import com.minic.kt.base.GlideApp
import com.minic.kt.base.GlideRequest
import jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation


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
        load(context, url, ImageFrom.getDefaultOptions() ?: ImageLoaderOptions(), imageView)
    }

    override fun load(context: Context, url: String, options: ImageLoaderOptions, imageView: ImageView) {
        val requestOptions = RequestOptions()
        GlideApp.with(context)
                .load(url)
                .applyOption(requestOptions, options)
                .applyCacheStrategy(requestOptions, options)
                .applyBitmapTransforms(requestOptions, options)
                .apply(requestOptions)
                .into(imageView)
    }

    @SuppressLint("CheckResult")
    fun GlideRequest<*>.applyOption(requestOptions: RequestOptions, options: ImageLoaderOptions): GlideRequest<*> {
        requestOptions.placeholder(options.placeHolder)
        requestOptions.error(options.errorHolder)
        apply(requestOptions)
        return this
    }

    @SuppressLint("CheckResult")
    fun GlideRequest<*>.applyCacheStrategy(requestOptions: RequestOptions, options: ImageLoaderOptions): GlideRequest<*> {
        requestOptions.skipMemoryCache(options.isSkipMemoryCache)
        requestOptions.diskCacheStrategy(if (options.isSkipDiskCache) DiskCacheStrategy.NONE else DiskCacheStrategy.ALL)
        return this
    }

    @SuppressLint("CheckResult")
    fun GlideRequest<*>.applyBitmapTransforms(requestOptions: RequestOptions, options: ImageLoaderOptions): GlideRequest<*> {
        val transforms = mutableListOf<Transformation<Bitmap>>()
        // 缩放类型
        when (options.scaleType) {
            ImageLoaderOptions.CENTER_CROP -> transforms.add(CenterCrop())
            ImageLoaderOptions.FIT_CENTER -> transforms.add(FitCenter())
            else -> transforms.add(CenterCrop())
        }
        //全圆角/纯圆形/四个方向有部分圆角
        if (options.radius > 0) { // 全圆角
            transforms.add(RoundedCornersTransformation(options.radius, 0))
        } else if (options.isCircle) { // 圆形
            transforms.add(CropCircleWithBorderTransformation(options.borderSize, options.borderColor))
        } else { // 分别四个圆角
            if (options.topLeftRadius > 0) {
                transforms.add(RoundedCornersTransformation(options.topLeftRadius,
                        0, RoundedCornersTransformation.CornerType.TOP_LEFT))
            }
            if (options.topRightRadius > 0) {
                transforms.add(RoundedCornersTransformation(options.topRightRadius,
                        0, RoundedCornersTransformation.CornerType.TOP_RIGHT))
            }
            if (options.bottomLeftRadius > 0) {
                transforms.add(RoundedCornersTransformation(options.bottomLeftRadius,
                        0, RoundedCornersTransformation.CornerType.BOTTOM_LEFT))
            }
            if (options.bottomRightRadius > 0) {
                transforms.add(RoundedCornersTransformation(options.bottomRightRadius,
                        0, RoundedCornersTransformation.CornerType.BOTTOM_RIGHT))
            }
        }
        // 应用于Glide
        if (transforms.isNotEmpty()) {
            requestOptions.transform(MultiTransformation<Bitmap>(transforms))
        }
        return this
    }

}