package com.minic.kt.ui.fragment.adapter.viewbinder

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.minic.kt.R
import com.minic.kt.base.viewbinder.BaseViewBinder
import com.minic.kt.data.model.gank.home.ArticleData
import com.minic.kt.databinding.ItemHomeArticleBinding
import com.minic.kt.ui.fragment.HomeViewPagerFragmentDirections


class ArticleViewBinder : BaseViewBinder<ArticleData, ItemHomeArticleBinding>(R.layout.item_home_article) {
    override fun bindTo(holder: RecyclerView.ViewHolder, bind: ItemHomeArticleBinding, item: ArticleData) {
        bind.item = item
        bind.root.setOnClickListener {
            val direction = HomeViewPagerFragmentDirections.actionHomeViewpagerFragmentToBrowserFragment(item.link, item.title)
            it.findNavController().navigate(direction)
        }
        bind.viewLine.visibility = if (adapter?.items.size == holder.adapterPosition) View.GONE else View.VISIBLE
        bind.executePendingBindings()
    }
}


