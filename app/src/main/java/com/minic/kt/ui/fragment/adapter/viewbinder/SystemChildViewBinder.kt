package com.minic.kt.ui.fragment.adapter.viewbinder

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.minic.kt.R
import com.minic.kt.base.viewbinder.BaseViewBinder
import com.minic.kt.data.model.gank.home.BannerData
import com.minic.kt.data.model.gank.home.SystemTree
import com.minic.kt.databinding.ItemHomeBannerBinding
import com.minic.kt.utils.ext.loadImage
import com.youth.banner.loader.ImageLoader


class SystemChildViewBinder : BaseViewBinder<SystemTree, ItemHomeBannerBinding>(R.layout.item_home_banner) {
    override fun bindTo(holder: RecyclerView.ViewHolder, bind: ItemHomeBannerBinding, item: SystemTree) {
        bind.executePendingBindings()
    }
}


