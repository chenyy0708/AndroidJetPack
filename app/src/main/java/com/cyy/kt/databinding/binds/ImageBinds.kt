package com.cyy.kt.databinding.binds

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.cyy.kt.R

/**
 * 页面描述：ImageBinds
 */

@BindingAdapter("app:imageUrl")
fun bindImgUrl(imageView: ImageView, url: String?) {
    url?.let {
        Glide.with(imageView.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .into(imageView)
    }
}