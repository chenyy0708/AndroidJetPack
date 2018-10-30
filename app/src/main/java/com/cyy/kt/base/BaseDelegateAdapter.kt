package com.cyy.kt.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper

/**
 * @author       :ChenYangYi
 * @date         :2018/10/30/16:08
 * @description  :Vlayout框架基类适配器
 * @github       :https://github.com/chenyy0708
 */
open class BaseDelegateAdapter(
        private val mContext: Context, private val mLayoutHelper: LayoutHelper,
        private val mLayoutId: Int, private val mCount: Int, private val mViewTypeItem: Int) : DelegateAdapter.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        if (viewType == mViewTypeItem) {
            return BaseViewHolder(LayoutInflater.from(mContext).inflate(mLayoutId, parent, false))
        }
        return BaseViewHolder(LayoutInflater.from(mContext).inflate(mLayoutId, parent, false))
    }

    override fun getItemCount(): Int {
        return mCount
    }

    override fun onCreateLayoutHelper(): LayoutHelper {
        return mLayoutHelper
    }

    /**
     * 必须重写不然会出现滑动不流畅的情况
     */
    override fun getItemViewType(position: Int): Int {
        return mViewTypeItem
    }

    /**
     * 子类adapter实现
     */
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    }

}