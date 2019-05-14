package com.minic.kt

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.minic.base.base.BaseActivity
import com.minic.base.extens.initToolbar
import com.minic.kt.databinding.ActivityMainBinding
import com.minic.kt.ui.fragment.HomeFragment
import com.ncapdevi.fragnav.FragNavController
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class MainActivity : BaseActivity<ActivityMainBinding>(), NavigationView.OnNavigationItemSelectedListener {

    private val fragNavController: FragNavController = FragNavController(supportFragmentManager, R.id.fl_continer)

    override fun getLayoutRes(): Int = R.layout.activity_main

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein)
        bind<MainActivity>() with instance(this@MainActivity)
    }

    override fun initData(savedInstanceState: Bundle?) {
        initToolbar(mBinding.includeToolbar.toolBar, mTitle = getString(R.string.app_name))
        syncToolBar(mBinding.includeToolbar.toolBar)
        val mFragments = listOf<Fragment>(
                HomeFragment.newInstance("Android"),
                HomeFragment.newInstance("iOS"),
                HomeFragment.newInstance("福利"),
                HomeFragment.newInstance("休息视频"),
                HomeFragment.newInstance("拓展资源"),
                HomeFragment.newInstance("前端"),
                HomeFragment.newInstance("all")
        )
        fragNavController.apply {
            rootFragments = mFragments
        }
        fragNavController.initialize(FragNavController.TAB1, savedInstanceState)
        mBinding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        fragNavController.onSaveInstanceState(outState!!)
    }

    private fun syncToolBar(toolbar: Toolbar) {
        val toggle = ActionBarDrawerToggle(
                this, mBinding.drawerLayout, toolbar, R.string.open,
                R.string.close)
        mBinding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.android -> fragNavController.switchTab(FragNavController.TAB1)
            R.id.ios -> fragNavController.switchTab(FragNavController.TAB2)
//            R.id.welfare -> fragNavController.switchTab(FragNavController.TAB1)
//            R.id.video -> fragNavController.switchTab(FragNavController.TAB1)
//            R.id.resource -> fragNavController.switchTab(FragNavController.TAB1)
//            R.id.web -> fragNavController.switchTab(FragNavController.TAB1)
//            R.id.all -> fragNavController.switchTab(FragNavController.TAB1)
        }
        mBinding.drawerLayout.closeDrawers()
        return true
    }
}


