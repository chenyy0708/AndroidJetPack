package com.minic.kt.ui.fragment.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.minic.base.base.BaseFragment
import com.minic.base.net.exception.doError
import com.minic.kt.R
import com.minic.kt.databinding.FragmentProjectChildBinding
import com.minic.kt.ui.fragment.adapter.ProjectChildAdapter
import com.minic.kt.ui.fragment.vm.ProjectChildVM


class ProjectChildFragment : BaseFragment<FragmentProjectChildBinding>() {
    override fun getLayoutRes(): Int = R.layout.fragment_project_child
    override fun getStatusLayout(): View = mBinding.recyclerView

    var viewModel: ProjectChildVM? = null

    companion object {
        fun newInstance(projectType: Int): ProjectChildFragment {
            val bundle = Bundle()
            val fragment = ProjectChildFragment()
            bundle.putInt(PROJECT_TYPE, projectType)
            fragment.arguments = bundle
            return fragment
        }

        const val PROJECT_TYPE = "project_type"

    }

    override fun initData(savedInstanceState: Bundle?) {
        initListener()
        val cid = arguments?.getInt(PROJECT_TYPE)
        mBinding.vm = ProjectChildVM(cid!!).apply { viewModel = this }
        viewModel?.let { viewLifecycleOwner.lifecycle.addObserver(it) }
        val adapter = ProjectChildAdapter()
        mBinding.recyclerView.layoutManager = LinearLayoutManager(mContext)
        mBinding.recyclerView.adapter = adapter
        viewModel?.mList?.observe(viewLifecycleOwner) { adapter.submitList(it) }

        viewModel?.refreshComplete?.observe(viewLifecycleOwner) { mBinding.swipeLayout.isRefreshing = !it }

    }

    private fun initListener() {
        mBinding.swipeLayout.setOnRefreshListener { viewModel?.mList?.value?.dataSource?.invalidate() }
        viewModel?.throwable?.observe(viewLifecycleOwner) { doError(it) }
    }

}
