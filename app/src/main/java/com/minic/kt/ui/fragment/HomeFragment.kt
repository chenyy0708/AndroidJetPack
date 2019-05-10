package com.minic.kt.ui.fragment

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.minic.base.base.BaseFragment
import com.minic.base.extens.viewModel
import com.minic.base.net.exception.doError
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.databinding.MainFragmentBinding
import com.minic.kt.ui.fragment.adapter.HomeAdapter
import com.minic.kt.ui.fragment.vm.HomeVM
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
        bind<HomeVM>() with scoped(AndroidLifecycleScope).singleton {
            instance<HomeFragment>().viewModel(HomeVM::class.java)
        }
    }
    // 注入MainViewModel管理业务数据
    private val homeViewModel: HomeVM by instance()

    companion object {
        fun newInstance(): HomeFragment {
            val bundle = Bundle()
            val homeFragment = HomeFragment()
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        val adapter = HomeAdapter()
        mBinding.vm = homeViewModel
        mBinding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        mBinding.recyclerView.adapter = adapter
        mBinding.swipeLayout.setColorSchemeColors(ContextCompat.getColor(mContext, R.color.colorPrimary))
        mBinding.swipeLayout.setOnRefreshListener {
            homeViewModel.mList.value?.dataSource?.invalidate()
        }
        homeViewModel.throwable.observe(this, Observer {
            doError(it)
        })
        homeViewModel.mList.observe(this, Observer {
            adapter.submitList(it)
        })
        homeViewModel.refreshComplete.observe(this, Observer {
            mBinding.swipeLayout.isRefreshing = !it
        })
    }

}