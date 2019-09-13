package com.minic.kt.ui.fragment.adapter.viewbinder

import com.minic.kt.R
import com.minic.kt.base.viewbinder.BaseViewBinder
import com.minic.kt.data.model.gank.home.ArticleData
import com.minic.kt.databinding.ItemHomeBinding


class ArticleViewBinder : BaseViewBinder<ArticleData, ItemHomeBinding>(R.layout.item_home) {
    override fun bindTo(bind: ItemHomeBinding, item: ArticleData) {
        bind.item = item
    }
}


