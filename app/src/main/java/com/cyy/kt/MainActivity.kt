package com.cyy.kt

import android.os.Bundle
import android.widget.TextView
import com.cyy.base.base.BaseActivity
import com.cyy.base.mvp.IModel
import com.cyy.kt.anko.MainActivityUI
import com.cyy.kt.bean.DouBanBook
import com.cyy.kt.bean.MeizhiData
import com.cyy.kt.mvp.TestContract
import com.cyy.kt.mvp.TestModel
import com.cyy.kt.mvp.TestPresenter
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class MainActivity : BaseActivity<TestPresenter>(), TestContract.View {

    /**
     * 初始化数据
     */
    override fun initData(savedInstanceState: Bundle?) {
    }

    fun getMeizhi() {
        mPresenter.getMeizhi()
    }

    fun getDouBanBook() {
        mPresenter.getDouBanBook()
    }

    /**
     * 显示信息
     */
    override fun setMeizhi(str: MeizhiData) {
        find<TextView>(R.id.tv_home).text = str.toString()
    }

    override fun setBook(str: DouBanBook) {
        find<TextView>(R.id.tv_home).text = str.toString()
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

    override fun getLayoutRes() {
        MainActivityUI().setContentView(this)
    }

}


