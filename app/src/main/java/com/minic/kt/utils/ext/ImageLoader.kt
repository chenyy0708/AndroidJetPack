package com.minic.kt.utils.ext

import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.minic.kt.R
import com.minic.kt.base.GlideApp

/**
 * @ClassName: ImageLoader
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-10 15:16
 */

fun ImageView.loadImage(any: Any?, radius: Int = 0) {
    GlideApp.with(this.context)
            .load(any)
            .placeholder(R.mipmap.ic_launcher_round)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.mipmap.ic_launcher_round)
            .centerCrop()
//            .transition(DrawableTransitionOptions.with(
//                    DrawableCrossFadeFactory.Builder(300).setCrossFadeEnabled(true).build()))
            .into(this)
}