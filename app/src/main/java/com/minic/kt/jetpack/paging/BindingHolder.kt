package com.minic.kt.jetpack.paging

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @ClassName: BindingHolder
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-10 10:30
 */
class BindingHolder<out VB : ViewDataBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)