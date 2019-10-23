package com.minic.kt.ui.fragment.adapter.viewbinder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.minic.base.extens.openActivity
import com.minic.imageload.loadIV
import com.minic.kt.R
import com.minic.kt.base.viewbinder.BaseViewBinder
import com.minic.kt.data.model.gank.home.ArticleData
import com.minic.kt.databinding.ItemHomeArticleBinding
import com.minic.kt.ui.activity.common.BrowserActivity


class ArticleViewBinder : BaseViewBinder<ArticleData, ItemHomeArticleBinding>(R.layout.item_home_article) {
    override fun bindTo(holder: RecyclerView.ViewHolder, bind: ItemHomeArticleBinding, item: ArticleData) {
        bind.item = item
        bind.root.setOnClickListener {
            holder.itemView.context.openActivity<BrowserActivity>(
                    "url" to item.link,
                    "title" to item.title
            )
        }
        bind.viewLine.visibility = if (adapter.items.size == holder.adapterPosition) View.GONE else View.VISIBLE
        var array = holder.itemView.context.resources.getStringArray(R.array.author_imgs)
        bind.ivAvatar.loadIV(array.random())
        bind.executePendingBindings()
    }
}


