package com.minic.base.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir

/**
 * @author       :ChenYangYi
 * @date         :2018/07/24/14:38
 * @description  :Activity基类
 * @github       :https://github.com/chenyy0708
 */
abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity(){

    /**
     * DataBind
     */
    protected lateinit var mBinding: VB

    /**
     * 上下文
     */
    protected lateinit var mContext: Context

    /**
     * 多状态布局管理类
     */
    open lateinit var mLoadService: LoadService<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        mContext = this
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
    private fun initBinding() {
        if (getLayoutRes() != 0) {
            mBinding = DataBindingUtil.setContentView(this, getLayoutRes())
            // 绑定LifeCycle
            mBinding.apply {
                lifecycleOwner = this@BaseActivity
            }
        }
    }

    /**
     * 初始化数据
     */
    protected abstract fun initData(savedInstanceState: Bundle?)

    @LayoutRes
    abstract fun getLayoutRes(): Int
}