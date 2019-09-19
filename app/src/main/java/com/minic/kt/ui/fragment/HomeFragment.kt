package com.minic.kt.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.drakeet.multitype.MultiTypeAdapter
import com.minic.base.base.BaseFragment
import com.minic.base.net.exception.showLoading
import com.minic.base.net.exception.showSuccess
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.data.model.gank.home.Article
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
    private var page: Int = 0

    override fun getStatusLayout(): View = mBinding.recyclerView

    /**
     * 刷新
     */
    private val refreshBlock: (MutableList<Any>?) -> Unit = {
        it?.let {
            showSuccess()
            items.clear()
            items.addAll(it)
            adapter.notifyDataSetChanged()
            mBinding.refreshLayout.finishRefresh()
        }
    }

    /**
     * 加载更多
     */
    private val loadMoreBlock: (Article?) -> Unit = {
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

    override val kodein: Kodein = Kodein.lazy {
        extend(App.INSTANCE.kodein)
        bind<HomeFragment>() with instance(this@HomeFragment)
    }
    private val homeViewModel: HomeVM by viewModels {
        HomeVMFactory(this, null)
    }

    override fun initData(savedInstanceState: Bundle?) {
        showLoading()
        initListener()
        mBinding.vm = homeViewModel
        viewLifecycleOwner.lifecycle.addObserver(homeViewModel)
        adapter.register(BannerViewBinder())
        adapter.register(ArticleViewBinder())
        adapter.items = items
        mBinding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        mBinding.recyclerView.adapter = adapter
    }

    private fun initListener() {
        homeViewModel.mItems.observe(viewLifecycleOwner, refreshBlock)
        homeViewModel.article.observe(viewLifecycleOwner, loadMoreBlock)
        mBinding.refreshLayout.setOnRefreshListener {
            page = 0
            homeViewModel.getData()
        }
        mBinding.refreshLayout.setOnLoadMoreListener {
            page++
            homeViewModel.getArticle(page)
        }
    }

}
