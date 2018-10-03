package com.cyy.kt.ui.fragment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import com.cyy.base.aop.annotation.SingleClick
import com.cyy.base.base.BaseFragment
import com.cyy.base.extens.showMsg
import com.cyy.base.extens.viewModel
import com.cyy.base.view.click.Presenter
import com.cyy.kt.R
import com.cyy.kt.base.App
import com.cyy.kt.databinding.TestFragmentBinding
import com.cyy.kt.ui.callback.LoadingCallback
import com.cyy.kt.viewmodel.TestViewModel
import org.kodein.di.Kodein
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

class TestFragment : BaseFragment<TestFragmentBinding>(), Presenter {

    override fun getLayoutRes(): Int = R.layout.test_fragment

    override fun getStatusLayout(): View = mBinding.container

    override val kodein: Kodein = Kodein.lazy {
        extend(App.INSTANCE.kodein)
        bind<TestFragment>() with instance(this@TestFragment)
        // AndroidComponentsWeakScope 保证了Activity级别的局部单例
        bind<TestViewModel>() with scoped(AndroidComponentsWeakScope).singleton {
            // 得到ViewModel实例
            instance<TestFragment>().viewModel(TestViewModel::class.java)
        }
    }

    // 注入MainViewModel管理业务数据
    private val testViewModel: TestViewModel by instance()

    companion object {
        fun newInstance(): TestFragment {
            val bundle = Bundle()
            val testFragment = TestFragment()
            testFragment.arguments = bundle
            return testFragment
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.vm = testViewModel
        mBinding.presenter = this
        // 展示Loading
        mLoadService.showCallback(LoadingCallback::class.java)
        // 获取数据
        testViewModel.getData()
        // 获取数据成功监听
        testViewModel.getLiveDataName().observe(this, Observer<String> {
            mLoadService.showSuccess()
        })
    }

    // 防止重复点击
    @SingleClick
    override fun onClick(v: View?) {
        showMsg("修改成功")
    }
}