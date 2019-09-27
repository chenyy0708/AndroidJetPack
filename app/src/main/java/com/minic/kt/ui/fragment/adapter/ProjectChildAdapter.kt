package com.minic.kt.ui.fragment.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.minic.base.extens.openActivity
import com.minic.kt.R
import com.minic.kt.data.model.gank.home.ArticleData
import com.minic.kt.databinding.ItemHomeProjectChildBinding
import com.minic.kt.jetpack.paging.PagingAdapter
import com.minic.kt.ui.activity.common.BrowserActivity
import com.minic.kt.utils.ext.loadImage


/**
 * @ClassName: HomeAdapter
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-09 09:20
 */
class ProjectChildAdapter : PagingAdapter<ArticleData, ItemHomeProjectChildBinding>(R.layout.item_home_project_child, mDiffCallback) {
    override fun bindTo(holder: RecyclerView.ViewHolder, bind: ItemHomeProjectChildBinding, item: ArticleData) {
        bind.item = item
        bind.root.setOnClickListener {
            holder.itemView.context.openActivity<BrowserActivity>(
                    "url" to item.link,
                    "title" to item.title
            )
        }
        val array = holder.itemView.context.resources.getStringArray(R.array.author_imgs)
        bind.ivAvatar.loadImage(array.random())
        bind.executePendingBindings()
    }
}

private val mDiffCallback = object : DiffUtil.ItemCallback<ArticleData>() {
    override fun areItemsTheSame(oldItem: ArticleData, newItem: ArticleData): Boolean {
        return oldItem.niceDate === newItem.niceDate
    }

    override fun areContentsTheSame(oldItem: ArticleData, newItem: ArticleData): Boolean {
        return newItem == oldItem
    }
}

