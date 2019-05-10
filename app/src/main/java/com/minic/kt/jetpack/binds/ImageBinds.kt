package com.minic.kt.jetpack.binds

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.minic.kt.utils.ext.loadImage

/**
 * 页面描述：ImageBinds
 */

@BindingAdapter("imageUrl")
fun bindImgUrl(imageView: ImageView, url: String?) {
    imageView.loadImage(url)
}