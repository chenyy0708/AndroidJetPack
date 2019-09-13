package com.minic.kt.ui.fragment

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.minic.base.base.BaseFragment
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.databinding.FragmentHomeBinding
import com.minic.kt.databinding.FragmentTestBinding
import com.minic.kt.ui.fragment.adapter.HomeAdapter
import com.minic.kt.ui.fragment.vm.HomeVM
import com.minic.kt.ui.fragment.vm.HomeVMFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class WeChartFragment : BaseFragment<FragmentTestBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_test

    override val kodein: Kodein = Kodein.lazy {
        extend(App.INSTANCE.kodein)
        bind<WeChartFragment>() with instance(this@WeChartFragment)
    }

    // 注入MainViewModel管理业务数据
    private val homeViewModel: HomeVM by viewModels {
        HomeVMFactory("")
    }

    override fun initData(savedInstanceState: Bundle?) {
        homeViewModel.also {
            it.lifecycleOwner = this@WeChartFragment
            lifecycle.addObserver(it)
        }
        val homeAdapter = HomeAdapter()
        mBinding.vm = homeViewModel
        mBinding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        mBinding.recyclerView.adapter = homeAdapter
        mBinding.swipeLayout.setColorSchemeColors(ContextCompat.getColor(mContext, R.color.colorPrimary))
        mBinding.tv.text = "公众号"
    }

}
