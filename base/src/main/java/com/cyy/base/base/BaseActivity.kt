package com.cyy.base.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cyy.base.mvp.BasePresenter
import com.cyy.base.mvp.IModel
import com.cyy.base.mvp.IView
import io.reactivex.disposables.CompositeDisposable

/**
 * @author       :ChenYangYi
 * @date         :2018/07/24/14:38
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
abstract class BaseActivity<P : BasePresenter<*, *>> : AppCompatActivity(), IView {

    lateinit var mPresenter: P

    /**
     * 管理RxJava 订阅
     */
    protected var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayoutRes()
        mPresenter = getP()
        mPresenter.attachView(this, getM())
        initData(savedInstanceState)
    }

    /**
     * M层
     */
    abstract fun getM(): IModel

    /**
     * 初始化数据
     */
    abstract fun initData(savedInstanceState: Bundle?)

    /**
     * 初始化P
     */
    abstract fun getP(): P

    abstract fun getLayoutRes()

    /**
     * 释放资源
     */
    override fun onDestroy() {
        mPresenter.detachView()
        // 取消执行的订阅
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
        super.onDestroy()
    }

    override fun getContext(): Activity {
        return this
    }
}