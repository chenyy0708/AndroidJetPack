package com.minic.kt.jetpack.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * @ClassName: PagingAdapter
 * @Description:BasePagingAdapter
 * @Author: ChenYy
 * @Date: 2019-05-10 09:52
 */
abstract class PagingAdapter<V, VB : ViewDataBinding>(@LayoutRes private val layoutId: Int,
                                                      mDiffCallback: DiffUtil.ItemCallback<V>) :
        PagedListAdapter<V, BindingHolder<VB>>(mDiffCallback) {

    private var onItemClickListener: ItemClickListener<V>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<VB> {
        val bindingHolder = BindingHolder<VB>(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                layoutId, parent, false))
        onItemClickListener?.let {
            bindingHolder.itemView.setOnClickListener {
                onItemClickListener!!(getItem(bindingHolder.layoutPosition)!!, bindingHolder.layoutPosition)
            }
        }
        return bindingHolder
    }

    override fun onBindViewHolder(holder: BindingHolder<VB>, position: Int) {
        val item = getItem(position)
        bindTo(holder,holder.binding, item!!)
    }

    /**
     * DataBind绑定Item
     */
    abstract fun bindTo(holder:RecyclerView.ViewHolder,bind: VB, item: V)

    fun setOnItemClickListener(onItemClickListener: ItemClickListener<V>) {
        this.onItemClickListener = onItemClickListener
    }
}

typealias ItemClickListener<T> = (item: T, position: Int) -> Unit
