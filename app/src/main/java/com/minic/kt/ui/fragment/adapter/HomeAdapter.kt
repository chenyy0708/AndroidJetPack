package com.minic.kt.ui.fragment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.minic.kt.R
import com.minic.kt.data.model.gank.Android
import com.minic.kt.databinding.ItemHomeBinding
import com.minic.kt.jetpack.paging.PagingAdapter


/**
 * @ClassName: HomeAdapter
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-09 09:20
 */
class HomeAdapter : PagingAdapter<Android, ItemHomeBinding>(R.layout.item_home, mDiffCallback) {
    override fun bindTo(bind: ItemHomeBinding, item: Android?) {
        bind.item = item
    }
}

private val mDiffCallback = object : DiffUtil.ItemCallback<Android>() {
    override fun areItemsTheSame(oldItem: Android, newItem: Android): Boolean {
        return oldItem._id === newItem._id
    }

    override fun areContentsTheSame(oldItem: Android, newItem: Android): Boolean {
        return newItem == oldItem
    }
}

