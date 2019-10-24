package com.minic.kt.ui.activity.test

import android.os.Bundle
import com.minic.base.base.BaseActivity
import com.minic.kt.R
import com.minic.kt.databinding.ActivityMotionStudyBinding
import kotlinx.android.synthetic.main.activity_motion_study.*


/**
 * 描述: MotionLayout动画测试
 * 作者: ChenYy
 * 日期: 2019-10-24 14:38
 */
class MotionLayoutActivity : BaseActivity<ActivityMotionStudyBinding>() {

    var isOpen = false

    /**
     * 初始化数据
     */
    override fun initData(savedInstanceState: Bundle?) {
        image_menu.setOnClickListener {
            if (isOpen) {
                mMotionLayout.transitionToStart()
            } else {
                mMotionLayout.transitionToEnd()
            }
            isOpen = !isOpen
        }
    }

    override fun getLayoutRes(): Int = R.layout.activity_motion_study
}