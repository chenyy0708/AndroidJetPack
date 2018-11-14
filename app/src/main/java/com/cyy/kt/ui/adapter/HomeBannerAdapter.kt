package com.cyy.kt.ui.adapter

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.alibaba.android.vlayout.LayoutHelper
import com.cyy.base.aop.annotation.SingleClick
import com.cyy.base.extens.logD
import com.cyy.kt.R
import com.cyy.kt.base.BaseDelegateAdapter
import com.cyy.kt.base.BaseViewHolder

/**
 * @author       :ChenYangYi
 * @date         :2018/10/30/15:47
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeBannerAdapter(
        private val mContext: Context, private val mLayoutHelper: LayoutHelper,
        private val mLayoutId: Int, private val mCount: Int, private val mViewTypeItem: Int) :
        BaseDelegateAdapter(mContext, mLayoutHelper, mLayoutId, mCount, mViewTypeItem), View.OnClickListener {
    @SingleClick
    override fun onClick(v: View?) {
        logD("fwefwetwerwer")
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.getView<LinearLayout>(R.id.ll_banner).setOnClickListener(this)
    }
}