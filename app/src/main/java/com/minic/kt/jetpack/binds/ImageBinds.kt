package com.minic.kt.jetpack.binds

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.minic.imageload.loadIV

/**
 * 页面描述：ImageBinds
 */

@BindingAdapter("imageUrl")
fun bindImgUrl(imageView: ImageView, url: String?) {
    url?.let {
        imageView.loadIV(it)
    }
}