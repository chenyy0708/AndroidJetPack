package com.minic.kt.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.minic.base.base.BaseFragment
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.databinding.FragmentProjectBinding
import com.minic.kt.ui.fragment.adapter.ProjectPagerAdapter
import com.minic.kt.ui.fragment.vm.HomeProjectVM

class ProjectFragment : BaseFragment<FragmentProjectBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_project

    private val viewModule: HomeProjectVM by viewModels()

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.vm = viewModule
        viewLifecycleOwner.lifecycle.addObserver(viewModule)
        mBinding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewModule.mList.observe(viewLifecycleOwner) { list ->
            mBinding.viewPager.adapter = ProjectPagerAdapter(this, list.map { ProjectChildFragment.newInstance(it.id) }.toMutableList())
            TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager) { tab, position ->
                tab.text = list[position].name
            }.attach()
        }
    }
}
