package com.cyy.kt

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.View
import com.cyy.base.aop.annotation.SingleClick
import com.cyy.base.base.BaseActivity
import com.cyy.base.extens.initToolbar
import com.cyy.base.extens.showMsg
import com.cyy.base.extens.viewModel
import com.cyy.base.view.click.Presenter
import com.cyy.kt.databinding.ActivityMainBinding
import com.cyy.kt.ui.callback.LoadingCallback
import com.cyy.kt.viewmodel.TestViewModel
import org.kodein.di.Kodein
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton


class MainActivity : BaseActivity<ActivityMainBinding>(), Presenter {
    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun getStatusLayout(): View = mBinding.mainContent.container

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein)
        bind<MainActivity>() with instance(this@MainActivity)
        // AndroidComponentsWeakScope 保证了Activity级别的局部单例
        bind<TestViewModel>() with scoped(AndroidComponentsWeakScope).singleton {
            // 得到ViewModel实例
            instance<MainActivity>().viewModel(TestViewModel::class.java)
        }
    }

    // 注入MainViewModel管理业务数据
    private val mainViewModel: TestViewModel by instance()

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.vm = mainViewModel
        mBinding.presenter = this
        initToolbar(mBinding.mainContent.toolBar, "MvvM框架", true)
        syncToolBar(mBinding.mainContent.toolBar)
        // 展示Loading
        mLoadService.showCallback(LoadingCallback::class.java)
        // 获取数据
        mainViewModel.getData()
        // 获取数据成功监听
        mainViewModel.getLiveDataName().observe(this, Observer<String> {
            mLoadService.showSuccess()
        })
    }

    private fun syncToolBar(toolbar: Toolbar) {
        val toggle = ActionBarDrawerToggle(
                this, mBinding.drawerLayout, toolbar, R.string.open,
                R.string.close)
        mBinding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    // 防止重复点击
    @SingleClick
    override fun onClick(v: View?) {
        showMsg("修改成功")
    }
}


