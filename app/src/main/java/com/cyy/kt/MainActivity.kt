package com.cyy.kt

import android.os.Bundle
import android.view.View
import com.cyy.base.aop.annotation.SingleClick
import com.cyy.base.base.BaseActivity
import com.cyy.base.view.click.Presenter
import com.cyy.kt.databinding.ActivityMainBinding
import com.cyy.kt.viewmodel.TestViewModel
import org.jetbrains.anko.toast


class MainActivity : BaseActivity<ActivityMainBinding>(), Presenter {

    private val viewModel: TestViewModel  by lazy {
        getInjectViewModel(TestViewModel::class.java)
    }

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.vm = viewModel
        // 点击事件
        mBinding.presenter = this
        viewModel.getData()
    }

    // 防止重复点击
    @SingleClick
    override fun onClick(v: View?) {
        toast("Click")
    }
}


