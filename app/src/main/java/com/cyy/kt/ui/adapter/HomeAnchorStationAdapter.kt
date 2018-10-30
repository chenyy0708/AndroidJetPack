package com.cyy.kt.ui.adapter

import android.content.Context
import com.alibaba.android.vlayout.LayoutHelper
import com.cyy.kt.base.BaseDelegateAdapter
import com.cyy.kt.base.BaseViewHolder

/**
 * @author       :ChenYangYi
 * @date         :2018/10/30/15:47
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeAnchorStationAdapter(
        private val mContext: Context, private val mLayoutHelper: LayoutHelper,
        private val mLayoutId: Int, private val mCount: Int, private val mViewTypeItem: Int) :
        BaseDelegateAdapter(mContext, mLayoutHelper, mLayoutId, mCount, mViewTypeItem) {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        
    }
}