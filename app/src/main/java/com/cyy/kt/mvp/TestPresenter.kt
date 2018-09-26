package com.cyy.kt.mvp

import com.cyy.base.mvp.BasePresenter
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

/**
 * @author       :ChenYangYi
 * @date         :2018/07/24/15:30
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class TestPresenter : BasePresenter<TestContract.Model, TestContract.View>(), TestContract.Presenter {
    override fun getDouBanBook() {
        getM().getDouBanBook()
                .subscribeBy(
                        onNext = { getV()?.setBook(it) },
                        onError = { println(it) })
                .addTo(compositeDisposable)
    }

    /**
     * 获取信息
     */
    override fun getMeizhi() {
        getM().getMeizhi()
                .subscribeBy(
                        onNext = { getV()?.setMeizhi(it) },
                        onError = { println(it) })
                .addTo(compositeDisposable)
    }
}