package com.cyy.base.databinding.binds

import androidx.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * 页面描述：ImageBinds
 */

@BindingAdapter("app:imageUrl")
fun bindImgUrl(imageView: ImageView, url: String?) {
    url?.let {
        Glide.with(imageView.context)
                .load(url)
                .into(imageView)
    }
}