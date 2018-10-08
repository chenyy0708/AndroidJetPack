package com.cyy.kt.ui.callback

import android.content.Context
import android.view.View
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.cyy.kt.R
import com.kingja.loadsir.callback.Callback

/**
 * @author       :ChenYangYi
 * @date         :2018/09/30/11:13
 * @description  :Lottie动画错误页面
 * @github       :https://github.com/chenyy0708
 */

class ErrorCallback : Callback() {
    override fun onCreateView(): Int = R.layout.layout_lottie

    override fun onViewCreate(context: Context?, view: View?) {
        super.onViewCreate(context, view)
        val lottieView = view!!.findViewById<LottieAnimationView>(R.id.animation_view)
        lottieView.setAnimation("error.json")
    }
}