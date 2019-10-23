package com.minic.base.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir

/**
 * @author       :ChenYangYi
 * @date         :2018/07/24/14:38
 * @description  :Fragment基类
 * @github       :https://github.com/chenyy0708
 */
abstract class BaseFragment<VB : ViewDataBinding> : Fragment() {

    /**
     * DataBind
     */
    protected lateinit var mBinding: VB

    /**
     * Fragment根布局
     */
    private lateinit var mRootView: View

    /**
     * 上下文
     */
    protected lateinit var mContext: Context

    /**
     * 多状态布局管理类
     */
    open lateinit var mLoadService: LoadService<Any>


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mRootView = LayoutInflater.from(context).inflate(getLayoutRes(), container, false)
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding(view)
        mContext = this.activity!!
        // 注册多状态布局
        mLoadService = LoadSir.getDefault().register(getStatusLayout())
        initData(savedInstanceState)
    }

    /**
     * 返回被多状态布局包裹的ViewGroup,默认为Activity根布局
     */
    protected open fun getStatusLayout(): View {
        return mBinding.root
    }

    /**
     * 创建DataBinding
     */
    private fun initBinding(rootView: View) {
        mBinding = DataBindingUtil.bind(rootView)!!
        // 绑定LifeCycle
        mBinding.apply {
            lifecycleOwner = this@BaseFragment
        }
    }

    /**
     * 初始化数据
     */
    abstract fun initData(savedInstanceState: Bundle?)

    @LayoutRes
    abstract fun getLayoutRes(): Int

}