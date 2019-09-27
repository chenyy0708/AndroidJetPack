package com.minic.kt.ui.fragment

import android.os.Bundle
import com.minic.base.base.BaseFragment
import com.minic.base.extens.initToolbar
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.databinding.FragmentHomeViewPagerBinding
import com.minic.kt.ui.fragment.adapter.WAPagerAdapter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance

/**
 * @ClassName: HomeViewPagerFragment
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-09-12 17:05
 */
class HomeViewPagerFragment : BaseFragment<FragmentHomeViewPagerBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_home_view_pager

    override val kodein: Kodein
        get() = Kodein.lazy {
            extend(App.INSTANCE.kodein)
            bind<HomeViewPagerFragment>() with instance(this@HomeViewPagerFragment)
        }

    override fun initData(savedInstanceState: Bundle?) {
        initToolbar(mBinding.includeToolbar.toolBar, mTitle = "WanAndroid", isBack = false)
        mBinding.viewPager.adapter = WAPagerAdapter(this)?.apply {
            mBinding.viewPager.offscreenPageLimit = itemCount
            mBinding.viewPager.isUserInputEnabled = false
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