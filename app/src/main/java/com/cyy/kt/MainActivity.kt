package com.cyy.kt

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.cyy.base.aop.annotation.SingleClick
import com.cyy.base.base.BaseActivity
import com.cyy.kt.databinding.ActivityMainBinding
import com.cyy.kt.viewmodel.TestViewModel
import org.jetbrains.anko.toast


class MainActivity : BaseActivity() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initData(savedInstanceState: Bundle?) {
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this@MainActivity, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
        binding.vm = viewModel
        binding.presenter = this
        viewModel.getData()
    }

    // 防止重复点击
    @SingleClick
    override fun onClick(v: View?) {
        toast("Click")
    }
}


