package com.minic.kt.ui.fragment

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.minic.base.base.BaseFragment
import com.minic.base.extens.comeOnStart
import com.minic.base.net.exception.doError
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.databinding.FragmentHomeBinding
import com.minic.kt.ui.activity.BROWSER_TITLE
import com.minic.kt.ui.activity.BROWSER_URL
import com.minic.kt.ui.activity.BrowserActivity
import com.minic.kt.ui.fragment.adapter.HomeAdapter
import com.minic.kt.ui.fragment.vm.HomeVM
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override val kodein: Kodein = Kodein.lazy {
        extend(App.INSTANCE.kodein)
        bind<HomeFragment>() with instance(this@HomeFragment)
    }
    // 注入MainViewModel管理业务数据
    private lateinit var homeViewModel: HomeVM

    companion object {
        fun newInstance(typeName: String): HomeFragment {
            val homeFragment = HomeFragment()
            val bundle = Bundle()
            bundle.putString(TYPE_NAME, typeName)
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        homeViewModel = HomeVM(this@HomeFragment.arguments?.getString(TYPE_NAME)!!).also {
            it.lifecycleOwner = this@HomeFragment
        }
        val homeAdapter = HomeAdapter()
        homeAdapter.setOnItemClickListener { item, _ ->
            mContext.comeOnStart(BrowserActivity::class.java) {
                it.putExtra(BROWSER_TITLE, item.desc)
                it.putExtra(BROWSER_URL, item.url)
            }
        }
        mBinding.vm = homeViewModel
        mBinding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        mBinding.recyclerView.adapter = homeAdapter
        mBinding.swipeLayout.setColorSchemeColors(ContextCompat.getColor(mContext, R.color.colorPrimary))
        mBinding.swipeLayout.setOnRefreshListener {
            homeViewModel.mList.value?.dataSource?.invalidate()
        }
        homeViewModel.throwable.observe(this, Observer {
            doError(it)
        })
        homeViewModel.mList.observe(this, Observer {
            homeAdapter.submitList(it)
        })
        homeViewModel.refreshComplete.observe(this, Observer {
            mBinding.swipeLayout.isRefreshing = !it
        })
    }

}

const val TYPE_NAME = "type_name"