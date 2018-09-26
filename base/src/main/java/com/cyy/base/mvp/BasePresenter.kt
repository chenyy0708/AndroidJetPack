package com.cyy.base.mvp

import io.reactivex.disposables.CompositeDisposable

/**
 * @author       :ChenYangYi
 * @date         :2018/07/24/14:23
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
open class BasePresenter<M : IModel, V : IView> : IPresenter<M, V> {

    /**
     * 管理RxJava 订阅
     */
    protected var compositeDisposable = CompositeDisposable()

    /**
     * View层
     */
    protected var mView: V? = null
    /**
     * Model层
     */
    protected lateinit var mModel: M

    /**
     * 关联MVPView到Presenter
     *
     * @param view MVPView实现类对象
     */
    override fun attachView(view: Any, model: Any) {
        this.mView = view as V
        this.mModel = model as M
    }

    /**
     * 解除关联到Presenter的MVPView(视图被销毁时调用该方法)
     */
    override fun detachView() {
        mView = null
        // 取消执行的订阅
        if (compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    fun getM(): M {
        return mModel
    }

    open fun getV(): V? {
        return mView
    }

    /**
     * 异常抛出
     */
    private class MvpViewNotAttachedException internal constructor() : RuntimeException("Please call IPresenter.attachView(IModel,IBaseView) before" + " requesting data to the IPresenter")

}