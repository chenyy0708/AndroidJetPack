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
import com.minic.kt.utils.FragmentChangeManager
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class MainActivity : BaseActivity<ActivityMainBinding>(), NavigationView.OnNavigationItemSelectedListener {

    private val mFragments by lazy {
        listOf<Fragment>(
                HomeFragment.newInstance("Android"),
                HomeFragment.newInstance("iOS"),
                HomeFragment.newInstance("福利"),
                HomeFragment.newInstance("休息视频"),
                HomeFragment.newInstance("拓展资源"),
                HomeFragment.newInstance("前端"),
                HomeFragment.newInstance("all")
        )
    }

    private lateinit var fragmentChangeManage: FragmentChangeManager

    override fun getLayoutRes(): Int = R.layout.activity_main

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein)
        bind<MainActivity>() with instance(this@MainActivity)
    }

    override fun initData(savedInstanceState: Bundle?) {
        initToolbar(mBinding.includeToolbar.toolBar, mTitle = getString(R.string.app_name))
        syncToolBar(mBinding.includeToolbar.toolBar)
        mBinding.navView.setNavigationItemSelectedListener(this)
        fragmentChangeManage = FragmentChangeManager(supportFragmentManager, R.id.fl_continer, mFragments)
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
            R.id.android -> fragmentChangeManage.setFragments(0)
            R.id.ios -> fragmentChangeManage.setFragments(1)
            R.id.welfare -> fragmentChangeManage.setFragments(2)
            R.id.video -> fragmentChangeManage.setFragments(3)
            R.id.resource -> fragmentChangeManage.setFragments(4)
            R.id.web -> fragmentChangeManage.setFragments(5)
            R.id.all -> fragmentChangeManage.setFragments(6)
        }
        mBinding.drawerLayout.closeDrawers()
        return true
    }
}


