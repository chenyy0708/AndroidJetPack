package com.cyy.kt

import android.os.Bundle
import com.cyy.base.base.BaseActivity
import com.cyy.base.mvp.IModel
import com.cyy.kt.bean.DouBanBook
import com.cyy.kt.bean.MeizhiData
import com.cyy.kt.mvp.TestContract
import com.cyy.kt.mvp.TestModel
import com.cyy.kt.mvp.TestPresenter

class MainActivity : BaseActivity<TestPresenter>(), TestContract.View {
    /**
     * 初始化数据
     */
    override fun initData(savedInstanceState: Bundle?) {
    }

    /**
     * 显示信息
     */
    override fun setMeizhi(str: MeizhiData) {
    }

    override fun setBook(str: DouBanBook) {
    }

    /**
     * 初始化P
     */
    override fun getP(): TestPresenter {
        return TestPresenter()
    }

    /**
     * M层
     */
    override fun getM(): IModel {
        return TestModel()
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

}


