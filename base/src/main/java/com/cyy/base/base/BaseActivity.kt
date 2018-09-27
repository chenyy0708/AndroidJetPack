package com.cyy.base.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.cyy.base.view.click.Presenter
import io.reactivex.disposables.CompositeDisposable

/**
 * @author       :ChenYangYi
 * @date         :2018/07/24/14:38
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
abstract class BaseActivity : AppCompatActivity(), Presenter {

//    protected lateinit var mBinding: VB

    protected lateinit var mContext: Context


    lateinit var factory: ViewModelProvider.Factory

    /**
     * 管理RxJava 订阅
     */
    protected var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData(savedInstanceState)
    }

    /**
     * 初始化数据
     */
    abstract fun initData(savedInstanceState: Bundle?)

    @LayoutRes
    abstract fun getLayoutRes(): Int

    fun <T : ViewModel> getInjectViewModel(modelClass: Class<T>) = ViewModelProviders.of(this, factory).get(modelClass)

    /**
     * 释放资源
     */
    override fun onDestroy() {
        // 取消执行的订阅
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
        super.onDestroy()
    }
}