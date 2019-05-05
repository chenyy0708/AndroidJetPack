package com.minic.base.callback

import android.content.Context
import android.view.View
import com.airbnb.lottie.LottieAnimationView
import com.kingja.loadsir.callback.Callback
import com.minic.base.R

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
        view!!.findViewById<LottieAnimationView>(R.id.animation_view).apply {
            setAnimation("error.json")
        }
    }
}