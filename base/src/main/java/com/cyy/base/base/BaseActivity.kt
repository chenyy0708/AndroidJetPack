package com.cyy.base.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein

/**
 * @author       :ChenYangYi
 * @date         :2018/07/24/14:38
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var mBinding: VB

    protected lateinit var mContext: Context



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        mContext = this
        initData(savedInstanceState)
    }

    /**
     * 创建DataBinding
     */
    private fun initBinding() {
        mBinding = DataBindingUtil.setContentView<VB>(this, getLayoutRes())
        // 绑定LifeCycle
        with(mBinding) {
            setLifecycleOwner(this@BaseActivity)
        }
    }

    /**
     * 初始化数据
     */
    abstract fun initData(savedInstanceState: Bundle?)

    @LayoutRes
    abstract fun getLayoutRes(): Int

}