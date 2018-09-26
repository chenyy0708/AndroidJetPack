package com.cyy.base.mvp

/**
 * @author       :ChenYangYi
 * @date         :2018/07/24/14:01
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
interface IPresenter<in M : IModel, in V : IView> {
    /**
     * 关联MVPView到Presenter
     *
     * @param view MVPView实现类对象
     */
    fun attachView(view: Any,model : Any)

    /**
     * 解除关联到Presenter的MVPView(视图被销毁时调用该方法)
     */
    fun detachView()
}