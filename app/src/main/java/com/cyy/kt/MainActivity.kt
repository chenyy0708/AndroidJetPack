package com.cyy.kt

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import com.cyy.base.base.BaseActivity
import com.cyy.base.extens.addFragment
import com.cyy.base.extens.initToolbar
import com.cyy.kt.databinding.MainActivityBinding
import com.cyy.kt.ui.fragment.TestFragment
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class MainActivity : BaseActivity<MainActivityBinding>() {
    override fun getLayoutRes(): Int = R.layout.main_activity

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein)
        bind<MainActivity>() with instance(this@MainActivity)
    }

    private var listOf = listOf<Fragment>(
            TestFragment.newInstance()
    )

    override fun initData(savedInstanceState: Bundle?) {
        initToolbar(mBinding.toolBar, "MvvM框架", true)
        syncToolBar(mBinding.toolBar)
        addFragment(listOf[0], R.id.fl_continer)
    }

    private fun syncToolBar(toolbar: Toolbar) {
        val toggle = ActionBarDrawerToggle(
                this, mBinding.drawerLayout, toolbar, R.string.open,
                R.string.close)
        mBinding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }
}


