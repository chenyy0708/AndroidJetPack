package com.minic.kt.ui.activity.test

import android.os.Bundle
import com.minic.base.base.BaseActivity
import com.minic.imageload.ImageFrom
import com.minic.imageload.ImageLoaderOptions
import com.minic.kt.R
import com.minic.kt.databinding.ActivityMotionStudyBinding
import com.minic.kt.utils.ext.dp2px
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
        ImageFrom.getImageLoader().load(this, "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1328874460,2431333110&fm=26&gp=0.jpg",
                ImageLoaderOptions().apply {
                    topLeftRadius = dp2px(10f)
                    topRightRadius = dp2px(10f)
                    bottomLeftRadius = dp2px(10f)
                    bottomRightRadius = dp2px(10f)
                    placeHolder = R.drawable.icon_navigation_not_selected
                    errorHolder = R.drawable.icon_me_not_selected
                }, iv_default)
    }

    override fun getLayoutRes(): Int = R.layout.activity_motion_study
}