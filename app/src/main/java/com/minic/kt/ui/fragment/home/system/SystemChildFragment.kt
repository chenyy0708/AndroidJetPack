package com.minic.kt.ui.fragment.home.system

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.drakeet.multitype.MultiTypeAdapter
import com.minic.base.base.BaseFragment
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.databinding.FragmentProjectChildBinding
import com.minic.kt.ui.fragment.adapter.viewbinder.SystemChildViewBinder
import com.minic.kt.ui.fragment.vm.SystemChildVM
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class SystemChildFragment : BaseFragment<FragmentProjectChildBinding>() {

    private val multiTypeAdapter = MultiTypeAdapter()
    private val items = ArrayList<Any>()

    override fun getLayoutRes(): Int = R.layout.fragment_project_child
    override val kodein: Kodein = Kodein.lazy {
        extend(App.INSTANCE.kodein)
        bind<SystemChildFragment>() with instance(this@SystemChildFragment)
    }
    val viewModel: SystemChildVM by viewModels()

    companion object {
        fun newInstance(): SystemChildFragment {
            return SystemChildFragment()
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        viewLifecycleOwner.lifecycle.addObserver(viewModel)
        mBinding.recyclerView.apply {
            adapter = multiTypeAdapter?.apply {
                register(SystemChildViewBinder())
                items = this@SystemChildFragment.items
            }
        }
        viewModel.systemData.observe(viewLifecycleOwner) {
            items.clear()
            items.addAll(it)
            multiTypeAdapter.notifyDataSetChanged()
        }
    }
}
