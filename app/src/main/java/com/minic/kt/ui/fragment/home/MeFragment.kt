package com.minic.kt.ui.fragment.home

import android.os.Bundle
import com.minic.base.base.BaseFragment
import com.minic.base.extens.openActivity
import com.minic.kt.R
import com.minic.kt.databinding.FragmentTestBinding
import com.minic.kt.ui.activity.test.MotionLayoutActivity


class MeFragment : BaseFragment<FragmentTestBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_test

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.tv.text = "我的"

        mBinding.tv.setOnClickListener {
            mContext?.openActivity<MotionLayoutActivity>()
        }
    }

}
