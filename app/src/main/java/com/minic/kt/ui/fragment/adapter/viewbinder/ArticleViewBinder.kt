package com.minic.kt.ui.fragment.adapter.viewbinder

import androidx.navigation.findNavController
import com.minic.kt.R
import com.minic.kt.base.viewbinder.BaseViewBinder
import com.minic.kt.data.model.gank.home.ArticleData
import com.minic.kt.databinding.ItemHomeBinding
import com.minic.kt.ui.fragment.HomeViewPagerFragmentDirections


class ArticleViewBinder : BaseViewBinder<ArticleData, ItemHomeBinding>(R.layout.item_home) {
    override fun bindTo(bind: ItemHomeBinding, item: ArticleData) {
        bind.item = item
        bind.root.setOnClickListener {
            val direction = HomeViewPagerFragmentDirections.actionHomeViewpagerFragmentToBrowserFragment(item.link, item.title)
            it.findNavController().navigate(direction)
        }
    }
}


