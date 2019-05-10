package com.minic.kt.jetpack.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

/**
 * @ClassName: PagingAdapter
 * @Description:BasePagingAdapter
 * @Author: ChenYy
 * @Date: 2019-05-10 09:52
 */
abstract class PagingAdapter<V, VB : ViewDataBinding>(@LayoutRes private val layoutId: Int,
                                                      mDiffCallback: DiffUtil.ItemCallback<V>) :
        PagedListAdapter<V, BindingHolder<VB>>(mDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<VB> {
        return BindingHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), layoutId, parent, false))
    }

    override fun onBindViewHolder(holder: BindingHolder<VB>, position: Int) {
        val item = getItem(position)
        bindTo(holder.binding, item)
    }

    /**
     * DataBind绑定Item
     */
    abstract fun bindTo(bind: VB, item: V?)
}