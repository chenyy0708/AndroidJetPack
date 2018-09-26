package com.cyy.kt.mvp

import com.cyy.base.mvp.IModel
import com.cyy.base.mvp.IPresenter
import com.cyy.base.mvp.IView
import com.cyy.kt.bean.DouBanBook
import com.cyy.kt.bean.MeizhiData
import io.reactivex.Observable

/**
 * @author       :ChenYangYi
 * @date         :2018/07/24/15:21
 * @description  :测试契约类
 * @github       :https://github.com/chenyy0708
 */
interface TestContract {
    interface Model : IModel {
        fun getMeizhi(): Observable<MeizhiData>
        fun getDouBanBook(): Observable<DouBanBook>
    }

    interface View : IView {
        /**
         * 显示信息
         */
        fun setMeizhi(str: MeizhiData)

        fun setBook(str: DouBanBook)
    }

    interface Presenter : IPresenter<Model, View> {
        /**
         * 获取信息
         */
        fun getMeizhi()

        fun getDouBanBook()

    }
}