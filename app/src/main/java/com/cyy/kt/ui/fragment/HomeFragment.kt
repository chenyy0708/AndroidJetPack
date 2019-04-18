package com.cyy.kt.ui.fragment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.FloatLayoutHelper
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.cyy.base.base.BaseFragment
import com.cyy.base.extens.showMsg
import com.cyy.base.extens.viewModel
import com.cyy.base.net.exception.doError
import com.cyy.base.net.exception.showLoading
import com.cyy.base.net.exception.showSuccess
import com.cyy.kt.R
import com.cyy.kt.base.App
import com.cyy.kt.base.BaseDelegateAdapter
import com.cyy.kt.base.Constant
import com.cyy.kt.databinding.MainFragmentBinding
import com.cyy.kt.databinding.viewmodel.HomeViewModel
import com.cyy.kt.ui.adapter.*
import io.flutter.facade.Flutter
import org.kodein.di.Kodein
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

class HomeFragment : BaseFragment<MainFragmentBinding>() {

    override fun getLayoutRes(): Int = R.layout.main_fragment

    override val kodein: Kodein = Kodein.lazy {
        extend(App.INSTANCE.kodein)
        bind<HomeFragment>() with instance(this@HomeFragment)
        // AndroidComponentsWeakScope 保证了Activity级别的局部单例
        bind<HomeViewModel>() with scoped(AndroidComponentsWeakScope).singleton {
            // 得到ViewModel实例
            instance<HomeFragment>().viewModel(HomeViewModel::class.java)
        }
    }

    // 注入MainViewModel管理业务数据
    private val homeViewModel: HomeViewModel by instance()

    private lateinit var layoutManager: VirtualLayoutManager
    private lateinit var viewPool: RecyclerView.RecycledViewPool
    private lateinit var delegateAdapter: DelegateAdapter
    private lateinit var mAdapters: MutableList<BaseDelegateAdapter>

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
        // 初始化VirtualLayoutManager
        layoutManager = VirtualLayoutManager(activity!!)
        mBinding.recyclerView.layoutManager = layoutManager
        //设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）
        viewPool = RecyclerView.RecycledViewPool()
        mBinding.recyclerView.recycledViewPool = viewPool
        viewPool.setMaxRecycledViews(0, 10)
        // 设置适配器
        mAdapters = ArrayList()
//        initAdapter()
        delegateAdapter = DelegateAdapter(layoutManager, true)
        mBinding.recyclerView.adapter = delegateAdapter
        delegateAdapter.setAdapters(mAdapters.toList())

        // 1. 通过Flutter.createView创建FlutterView组件方式

        var flutterView = Flutter.createView(activity!!, lifecycle, "flutterView")
        var layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        // 2. 将Flutter 视图添加到原生布局中
        mBinding.llContainer.addView(flutterView, layoutParams)
    }

    /**
     * 创建首页Adapter
     */
    private fun initAdapter() {
        // 轮播图Adapter
        val bannerAdapter = HomeBannerAdapter(activity!!, LinearLayoutHelper(), R.layout.item_home_banner, 1, Constant.HOME_BANNER)
        mAdapters.add(bannerAdapter)
        // Tab
        val adapter1 = HomeTabAdapter(activity!!, FloatLayoutHelper(), R.layout.item_home_tab, 1, Constant.HOME_TAB)
        mAdapters.add(adapter1)
        // 推荐歌单
        val adapter2 = HomeSongListAdapter(activity!!, LinearLayoutHelper(), R.layout.item_home_recommend_song_list, 1, Constant.RECOMMEND_SONG_LIST)
        mAdapters.add(adapter2)
        // 最新音乐
        val adapter3 = HomeLatestMusicAdapter(activity!!, LinearLayoutHelper(), R.layout.item_home_latest_music, 1, Constant.LATEST_MUSIC)
        mAdapters.add(adapter3)
        // 主播电台
        val adapter4 = HomeAnchorStationAdapter(activity!!, LinearLayoutHelper(), R.layout.item_home_auchor_station, 1, Constant.ANCHOR_STATION)
        mAdapters.add(adapter4)
    }

}