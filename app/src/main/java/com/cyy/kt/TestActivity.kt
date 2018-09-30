package com.cyy.kt

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.cyy.base.base.BaseActivity
import com.cyy.base.extens.navigateToActivity
import com.cyy.kt.databinding.TestActivityBinding

/**
 * @author       :ChenYangYi
 * @date         :2018/09/29/09:07
 * @description  :
 * @github       :https://github.com/chenyy0708
 */

class TestActivity : BaseActivity<TestActivityBinding>() {
    override fun getLayoutRes(): Int = R.layout.test_activity

    override fun initData(savedInstanceState: Bundle?) {
        mBinding.bt.setOnClickListener {
            navigateToActivity(MainActivity::class.java)
        }
    }

}