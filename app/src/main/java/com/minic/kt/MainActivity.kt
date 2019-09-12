package com.minic.kt

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.minic.base.base.BaseActivity
import com.minic.base.extens.initToolbar
import com.minic.kt.databinding.ActivityMainBinding
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutRes(): Int = R.layout.activity_main

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein)
        bind<MainActivity>() with instance(this@MainActivity)
    }

    override fun initData(savedInstanceState: Bundle?) {
        initToolbar(mBinding.includeToolbar.toolBar, mTitle = getString(R.string.app_name))
        val navController = findNavController(R.id.nav_home_fragment)
        val appBarConfiguration = AppBarConfiguration(navGraph = navController.graph)
        mBinding.includeToolbar.toolBar.setupWithNavController(navController, appBarConfiguration)
        mBinding.bottomNavView.setupWithNavController(navController)
        mBinding.bottomNavView.setOnNavigationItemReselectedListener {item->
            onNavDestinationSelected(item, navController)
        }
    }
}


