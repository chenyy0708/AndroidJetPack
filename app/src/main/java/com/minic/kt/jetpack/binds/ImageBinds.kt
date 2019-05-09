package com.minic.kt.jetpack.binds

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.pingerx.imagego.core.strategy.loadImage

/**
 * 页面描述：ImageBinds
 */

@BindingAdapter("app:imageUrl")
fun bindImgUrl(imageView: ImageView, url: String?) {
    loadImage(url, imageView)
}