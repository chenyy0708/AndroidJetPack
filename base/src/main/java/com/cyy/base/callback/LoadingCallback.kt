package com.cyy.base.callback

import android.content.Context
import android.view.View
import com.airbnb.lottie.LottieAnimationView
import com.cyy.base.R
import com.kingja.loadsir.callback.Callback

/**
 * @author       :ChenYangYi
 * @date         :2018/09/30/11:13
 * @description  :Lottie动画加载页面
 * @github       :https://github.com/chenyy0708
 */

class LoadingCallback : Callback() {
    override fun onCreateView(): Int = R.layout.layout_lottie

    override fun onViewCreate(context: Context?, view: View?) {
        super.onViewCreate(context, view)
        val lottieView = view!!.findViewById<LottieAnimationView>(R.id.animation_view)
        lottieView.setAnimation("loading.json")
    }
}