package com.minic.kt.ui.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.drakeet.multitype.MultiTypeAdapter
import com.minic.base.base.BaseFragment
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.data.model.gank.home.Article
import com.minic.kt.data.model.gank.home.BannerData
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

    override val kodein: Kodein = Kodein.lazy {
        extend(App.INSTANCE.kodein)
        bind<HomeFragment>() with instance(this@HomeFragment)
    }
    private val homeViewModel: HomeVM by viewModels {
        HomeVMFactory("")
    }

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.vm = homeViewModel
        homeViewModel.apply {
            lifecycleOwner = this@HomeFragment
            lifecycle.addObserver(this)
        }
        adapter.register(BannerViewBinder())
        adapter.register(ArticleViewBinder())
        adapter.items = items
        mBinding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        mBinding.recyclerView.adapter = adapter
        homeViewModel.banners.observe(this, Observer<MutableList<BannerData>> {
            items.add(it)
            adapter.notifyDataSetChanged()
        })
        homeViewModel.article.observe(this, Observer<Article> {
            items.addAll(it.datas)
            adapter.notifyDataSetChanged()
            mBinding.refreshLayout.finishRefresh()
        })
        mBinding.refreshLayout.setOnRefreshListener {
            homeViewModel.getData()
        }
    }

}
