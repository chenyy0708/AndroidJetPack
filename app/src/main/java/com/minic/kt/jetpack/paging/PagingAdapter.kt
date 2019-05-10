package com.minic.kt.jetpack.paging

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.minic.base.adapter.SimpleViewHolder

/**
 * @ClassName: PagingAdapter
 * @Description:BasePagingAdapter
 * @Author: ChenYy
 * @Date: 2019-05-10 09:52
 */
abstract class PagingAdapter<V>(@LayoutRes private val layoutId: Int,
                                mDiffCallback: DiffUtil.ItemCallback<V>) :
        PagedListAdapter<V, SimpleViewHolder>(mDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        return SimpleViewHolder(parent, layoutId)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        convert(holder, position)
    }

    abstract fun convert(holder: SimpleViewHolder, position: Int)
}