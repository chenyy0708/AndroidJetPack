package com.cyy.kt

import android.os.Bundle
import android.view.View
import com.cyy.base.aop.annotation.SingleClick
import com.cyy.base.base.BaseActivity
import com.cyy.base.extens.viewModel
import com.cyy.base.view.click.Presenter
import com.cyy.kt.databinding.ActivityMainBinding
import com.cyy.kt.viewmodel.TestViewModel
import org.jetbrains.anko.toast
import org.kodein.di.Kodein
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton


class MainActivity : BaseActivity<ActivityMainBinding>(), Presenter {

    override fun getLayoutRes(): Int = R.layout.activity_main

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein)
        bind<MainActivity>() with instance(this@MainActivity)
        /**
         * scoped(AndroidComponentsWeakScope)
         * 保证了Activity级别的局部单例
         */
        bind<TestViewModel>() with scoped(AndroidComponentsWeakScope).singleton {
            // 得到ViewModel实例
            instance<MainActivity>().viewModel(TestViewModel::class.java)
        }
    }

    // 注入MainViewModel管理业务数据
    private val mainViewModel: TestViewModel by instance()

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.vm = mainViewModel
        // 点击事件 可选
        mBinding.presenter = this
        // 绑定生命周期，用于取消订阅
        mainViewModel.getData()
    }

    // 防止重复点击
    @SingleClick
    override fun onClick(v: View?) {
        toast("Click")
    }
}


