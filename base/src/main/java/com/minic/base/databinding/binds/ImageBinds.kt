package com.minic.base.databinding.binds

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 * 页面描述：ImageBinds
 */

@BindingAdapter("app:imageUrl")
fun bindImgUrl(imageView: ImageView, url: String?) {
    url?.let {
    }
}