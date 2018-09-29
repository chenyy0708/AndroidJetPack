package com.cyy.kt

import android.os.Bundle
import android.view.View
import com.cyy.base.aop.annotation.SingleClick
import com.cyy.base.base.BaseActivity
import com.cyy.base.view.click.Presenter
import com.cyy.kt.databinding.ActivityMainBinding
import com.cyy.kt.di.mainModule
import com.cyy.kt.viewmodel.TestViewModel
import org.jetbrains.anko.toast
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class MainActivity : BaseActivity<ActivityMainBinding>(), Presenter,
        KodeinAware {

    override fun getLayoutRes(): Int = R.layout.activity_main

    protected val parentKodein by closestKodein()

    override val kodeinTrigger = KodeinTrigger()

    // 注入MainViewModel管理业务数据
    private val mainViewModel: TestViewModel by instance()

    /**
     * 导入Application中所有的单例使用
     */
    override val kodein: Kodein by retainedKodein {
        extend(parentKodein, copy = Copy.All)
        import(mainModule)
        bind<MainActivity>() with instance(this@MainActivity)
    }

    override fun initData(savedInstanceState: Bundle?) {
        kodeinTrigger.trigger()
        mBinding.vm = mainViewModel
        // 点击事件 可选
        mBinding.presenter = this
        // 绑定生命周期，用于取消订阅
        mainViewModel.getData()
    }

    // 防止重复点击
    @SingleClick
    override fun onClick(v: View?) {
        toast("Click")
    }
}


