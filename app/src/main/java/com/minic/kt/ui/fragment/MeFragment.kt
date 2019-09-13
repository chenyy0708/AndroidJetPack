package com.minic.kt.ui.fragment

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.minic.base.base.BaseFragment
import com.minic.base.extens.comeOnStart
import com.minic.base.extens.logD
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


class MeFragment : BaseFragment<FragmentTestBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_test

    override val kodein: Kodein = Kodein.lazy {
        extend(App.INSTANCE.kodein)
        bind<MeFragment>() with instance(this@MeFragment)
    }

    override fun initData(savedInstanceState: Bundle?) {
    }

}
