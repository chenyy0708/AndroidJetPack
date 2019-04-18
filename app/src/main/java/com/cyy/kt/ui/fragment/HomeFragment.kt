package com.cyy.kt.ui.fragment

import android.os.Bundle
import androidx.lifecycle.Observer
import com.cyy.base.base.BaseFragment
import com.cyy.base.extens.showMsg
import com.cyy.base.extens.viewModel
import com.cyy.base.net.exception.showLoading
import com.cyy.base.net.exception.showSuccess
import com.cyy.kt.R
import com.cyy.kt.base.App
import com.cyy.kt.databinding.MainFragmentBinding
import com.cyy.kt.databinding.viewmodel.HomeViewModel
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

class HomeFragment : BaseFragment<MainFragmentBinding>() {

    override fun getLayoutRes(): Int = R.layout.main_fragment

    override val kodein: Kodein = Kodein.lazy {
        extend(App.INSTANCE.kodein)
        bind<HomeFragment>() with instance(this@HomeFragment)
        bind<HomeViewModel>() with scoped(AndroidLifecycleScope).singleton {
            instance<HomeFragment>().viewModel(HomeViewModel::class.java)
        }
    }
    // 注入MainViewModel管理业务数据
    private val homeViewModel: HomeViewModel by instance()

    companion object {
        fun newInstance(): HomeFragment {
            val bundle = Bundle()
            val testFragment = HomeFragment()
            testFragment.arguments = bundle
            return testFragment
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        // 展示Loading
        showLoading()
        mBinding.vm = homeViewModel
        // 获取数据成功监听
        homeViewModel.name.observe(this, Observer {
            showSuccess()
            showMsg(it!!)
        })
        homeViewModel.throwable.observe(this, Observer {
            //            doError(it)
        })
//        var flutterView = Flutter.createView(activity!!, lifecycle, "flutterView")
//        var layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
//        // 2. 将Flutter 视图添加到原生布局中
//        mBinding.llContainer.addView(flutterView, layoutParams)
    }

}