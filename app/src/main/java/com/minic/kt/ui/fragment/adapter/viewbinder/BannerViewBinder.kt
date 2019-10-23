package com.minic.kt.ui.fragment.adapter.viewbinder

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.minic.imageload.loadIV
import com.minic.kt.R
import com.minic.kt.base.viewbinder.BaseViewBinder
import com.minic.kt.data.model.gank.home.BannerData
import com.minic.kt.databinding.ItemHomeBannerBinding
import com.youth.banner.loader.ImageLoader


class BannerViewBinder : BaseViewBinder<MutableList<BannerData>, ItemHomeBannerBinding>(R.layout.item_home_banner) {
    override fun bindTo(holder: RecyclerView.ViewHolder, bind: ItemHomeBannerBinding, item: MutableList<BannerData>) {
        bind.banner.setImageLoader(GlideImageLoader())
        bind.banner.setImages(item)
        bind.banner.start()
        bind.executePendingBindings()
    }

    class GlideImageLoader : ImageLoader() {
        override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
            if (path is BannerData) {
                imageView?.loadIV(path.imagePath)
            }
        }
    }
}


