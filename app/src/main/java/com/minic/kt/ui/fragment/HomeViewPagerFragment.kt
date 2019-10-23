package com.minic.kt.ui.fragment

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.minic.base.base.BaseFragment
import com.minic.base.extens.initToolbar
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.databinding.FragmentHomeViewPagerBinding
import com.minic.kt.ui.fragment.adapter.WAPagerAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @ClassName: HomeViewPagerFragment
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-09-12 17:05
 */
class HomeViewPagerFragment : BaseFragment<FragmentHomeViewPagerBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_home_view_pager

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.viewPager.apply {
            adapter = WAPagerAdapter(this@HomeViewPagerFragment).apply {
                // 默认加载全部的
                offscreenPageLimit = itemCount
            }
            // 静止手势滑动
            isUserInputEnabled = false
            // 显示第一个Page
            lifecycleScope.launch {
                delay(50)
                currentItem = 0
            }
        }
        mBinding.bottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> mBinding.viewPager.currentItem = 0
                R.id.project -> mBinding.viewPager.currentItem = 1
                R.id.wechart -> mBinding.viewPager.currentItem = 2
                R.id.system -> mBinding.viewPager.currentItem = 3
                R.id.me -> mBinding.viewPager.currentItem = 4
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

}