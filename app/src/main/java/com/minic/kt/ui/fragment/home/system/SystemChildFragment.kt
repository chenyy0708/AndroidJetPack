package com.minic.kt.ui.fragment.home.system

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.drakeet.multitype.MultiTypeAdapter
import com.minic.base.base.BaseFragment
import com.minic.kt.R
import com.minic.kt.databinding.FragmentProjectChildBinding
import com.minic.kt.ui.fragment.adapter.viewbinder.SystemChildViewBinder
import com.minic.kt.ui.fragment.vm.SystemChildVM


class SystemChildFragment : BaseFragment<FragmentProjectChildBinding>() {

    private val multiTypeAdapter = MultiTypeAdapter()
    private val items = ArrayList<Any>()

    override fun getLayoutRes(): Int = R.layout.fragment_project_child
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
