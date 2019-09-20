package com.minic.kt.ui.fragment.home

import android.os.Bundle
import com.minic.base.base.BaseFragment
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.databinding.FragmentTestBinding
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class WeChartFragment : BaseFragment<FragmentTestBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_test

    override val kodein: Kodein = Kodein.lazy {
        extend(App.INSTANCE.kodein)
        bind<WeChartFragment>() with instance(this@WeChartFragment)
    }

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.tv.text = "公众号"
    }

}