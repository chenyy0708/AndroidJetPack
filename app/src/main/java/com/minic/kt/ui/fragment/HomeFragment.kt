package com.minic.kt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.drakeet.multitype.MultiTypeAdapter
import com.minic.base.base.BaseFragment
import com.minic.base.extens.logD
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.databinding.FragmentHomeBinding
import com.minic.kt.ui.fragment.adapter.viewbinder.ArticleViewBinder
import com.minic.kt.ui.fragment.adapter.viewbinder.BannerViewBinder
import com.minic.kt.ui.fragment.vm.HomeVM
import com.minic.kt.ui.fragment.vm.HomeVMFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getLayoutRes(): Int = R.layout.fragment_home
    private val adapter = MultiTypeAdapter()
    private val items = ArrayList<Any>()

    private var isLoadData = false

    private var page: Int = 0

    override val kodein: Kodein = Kodein.lazy {
        extend(App.INSTANCE.kodein)
        bind<HomeFragment>() with instance(this@HomeFragment)
    }
    private val homeViewModel: HomeVM by viewModels {
        HomeVMFactory(this, null)
    }

    override fun initData(savedInstanceState: Bundle?) {
        homeViewModel.apply {
            lifecycleOwner = viewLifecycleOwner
            viewLifecycleOwner.lifecycle.addObserver(this)
        }
        homeViewModel.mItems.observe(viewLifecycleOwner) {
            logD(tag = "C", msg = "刷新数据${it?.size}")
            if (isLoadData) return@observe
            items.clear()
            items.addAll(it!!)
            adapter.notifyDataSetChanged()
            mBinding.refreshLayout.finishRefresh()
            isLoadData = true
        }
        homeViewModel.article.observe(viewLifecycleOwner) {
            logD(tag = "C", msg = "加载数据${it?.datas?.size}")
            it?.let {
                items.addAll(it.datas)
                adapter.notifyItemInserted(items.size - it.datas.size)
                if (page == it.pageCount) {
                    mBinding.refreshLayout.finishLoadMoreWithNoMoreData()
                } else {
                    mBinding.refreshLayout.finishLoadMore()
                }
            }
        }
        mBinding.vm = homeViewModel
        adapter.register(BannerViewBinder())
        adapter.register(ArticleViewBinder())
        adapter.items = items
        mBinding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        mBinding.recyclerView.adapter = adapter

        mBinding.refreshLayout.setOnRefreshListener {
            isLoadData = false
            page = 0
            homeViewModel.getData()
        }
        mBinding.refreshLayout.setOnLoadMoreListener {
            page++
            homeViewModel.getArticle(page)
        }
    }

}
