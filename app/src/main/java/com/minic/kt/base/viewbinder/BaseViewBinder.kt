package com.minic.kt.base.viewbinder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.drakeet.multitype.ItemViewBinder
import com.minic.kt.jetpack.paging.BindingHolder

abstract class BaseViewBinder<V, VB : ViewDataBinding>(@LayoutRes private val layoutId: Int) : ItemViewBinder<V, BindingHolder<VB>>() {

    override fun onBindViewHolder(holder: BindingHolder<VB>, item: V) {
        bindTo(holder.binding, item!!)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): BindingHolder<VB> {
        return BindingHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                layoutId, parent, false))
    }

    /**
     * DataBind绑定Item
     */
    abstract fun bindTo(bind: VB, item: V)
}
