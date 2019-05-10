package com.minic.kt.ui.fragment.adapter

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.minic.base.adapter.SimpleViewHolder
import com.minic.kt.R
import com.minic.kt.data.model.gank.Android
import com.minic.kt.jetpack.paging.PagingAdapter


/**
 * @ClassName: HomeAdapter
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-09 09:20
 */
class HomeAdapter : PagingAdapter<Android>(R.layout.item_home, mDiffCallback) {
    override fun convert(holder: SimpleViewHolder, position: Int) {
        holder.getView<TextView>(R.id.tv).text = getItem(position)?.desc
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

