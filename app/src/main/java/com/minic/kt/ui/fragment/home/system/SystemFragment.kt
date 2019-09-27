package com.minic.kt.ui.fragment.home.system

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.minic.base.base.BaseFragment
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.databinding.FragmentSystemBinding
import com.minic.kt.ui.fragment.home.MeFragment
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class SystemFragment : BaseFragment<FragmentSystemBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_system

    val mFragments = linkedMapOf<String, Fragment>(
            "体系" to SystemChildFragment(),
            "导航" to MeFragment()
    )

    override val kodein: Kodein = Kodein.lazy {
        extend(App.INSTANCE.kodein)
        bind<SystemFragment>() with instance(this@SystemFragment)
    }

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = mFragments.size

            override fun createFragment(position: Int): Fragment {
                return mFragments.toList()[position].second
            }
        }
        TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager) { tab, position ->
            tab.text = mFragments.toList()[position].first
        }.attach()
    }

}
