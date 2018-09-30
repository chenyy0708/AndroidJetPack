package com.cyy.kt

import android.os.Bundle
import android.view.View
import com.cyy.base.aop.annotation.SingleClick
import com.cyy.base.base.BaseActivity
import com.cyy.base.extens.showMsg
import com.cyy.base.extens.viewModel
import com.cyy.base.view.click.Presenter
import com.cyy.kt.databinding.ActivityMainBinding
import com.cyy.kt.viewmodel.TestViewModel
import com.kingja.loadsir.callback.ProgressCallback
import org.kodein.di.Kodein
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton


class MainActivity : BaseActivity<ActivityMainBinding>(), Presenter {
    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun getStatusLayout(): View = mBinding.container

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
        mLoadService.showCallback(ProgressCallback::class.java)
    }

    // 防止重复点击
    @SingleClick
    override fun onClick(v: View?) {
        showMsg("修改成功")
    }
}


