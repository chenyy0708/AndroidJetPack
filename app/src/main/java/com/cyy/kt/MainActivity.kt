package com.cyy.kt

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import com.cyy.base.base.BaseActivity
import com.cyy.base.extens.initToolbar
import com.cyy.kt.databinding.MainActivityBinding
import com.cyy.kt.ui.fragment.HomeFragment
import com.ncapdevi.fragnav.FragNavController
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class MainActivity : BaseActivity<MainActivityBinding>(), FragNavController.RootFragmentListener {
    override fun getRootFragment(p0: Int): Fragment {
        return mFragments[p0]
    }

    override fun getLayoutRes(): Int = R.layout.main_activity

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein)
        bind<MainActivity>() with instance(this@MainActivity)
    }

    private val mFragments = listOf<Fragment>(
            HomeFragment.newInstance()
    )

    lateinit var mNavController: FragNavController

    override fun initData(savedInstanceState: Bundle?) {
        initToolbar(mBinding.toolBar)
        syncToolBar(mBinding.toolBar)


        mNavController = FragNavController.newBuilder(savedInstanceState, supportFragmentManager, R.id.fl_continer)
                .rootFragmentListener(this, mFragments.size)
                .build()

        mNavController.switchTab(FragNavController.TAB1)
    }

    private fun syncToolBar(toolbar: Toolbar) {
        val toggle = ActionBarDrawerToggle(
                this, mBinding.drawerLayout, toolbar, R.string.open,
                R.string.close)
        mBinding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }
}


