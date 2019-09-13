package com.minic.kt.ui.fragment.adapter.viewbinder

import com.minic.kt.R
import com.minic.kt.base.viewbinder.BaseViewBinder
import com.minic.kt.data.model.gank.home.AcrticleData
import com.minic.kt.databinding.ItemHomeBinding


class ArticleViewBinder : BaseViewBinder<AcrticleData, ItemHomeBinding>(R.layout.item_home) {
    override fun bindTo(bind: ItemHomeBinding, item: AcrticleData) {
        bind.tv.text = item.title
    }
}


