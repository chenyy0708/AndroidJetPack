package com.minic.kt.ui.fragment

import android.os.Bundle
import androidx.lifecycle.Observer
import com.minic.base.base.BaseFragment
import com.minic.base.extens.showMsg
import com.minic.base.extens.viewModel
import com.minic.base.net.exception.showLoading
import com.minic.base.net.exception.showSuccess
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.databinding.MainFragmentBinding
import com.minic.kt.databinding.viewmodel.HomeViewModel
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
        showLoading()
        mBinding.vm = homeViewModel
        homeViewModel.name.observe(this, Observer {
            showSuccess()
            showMsg(it!!)
        })
        homeViewModel.throwable.observe(this, Observer {
            showMsg(it.message.toString())
        })
    }

}