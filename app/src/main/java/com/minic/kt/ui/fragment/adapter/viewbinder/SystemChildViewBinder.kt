package com.minic.kt.ui.fragment.adapter.viewbinder

import androidx.recyclerview.widget.RecyclerView
import com.minic.kt.R
import com.minic.kt.base.viewbinder.BaseViewBinder
import com.minic.kt.data.model.gank.home.SystemTree
import com.minic.kt.databinding.ItemHomeBannerBinding


class SystemChildViewBinder : BaseViewBinder<SystemTree, ItemHomeBannerBinding>(R.layout.item_home_banner) {
    override fun bindTo(holder: RecyclerView.ViewHolder, bind: ItemHomeBannerBinding, item: SystemTree) {
        bind.executePendingBindings()
    }
}


