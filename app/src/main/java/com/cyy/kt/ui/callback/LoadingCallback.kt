package com.cyy.kt.ui.callback

import com.cyy.kt.R
import com.kingja.loadsir.callback.Callback

/**
 * @author       :ChenYangYi
 * @date         :2018/09/30/11:13
 * @description  :Lottie动画加载页面
 * @github       :https://github.com/chenyy0708
 */

class LoadingCallback : Callback() {
    override fun onCreateView(): Int = R.layout.layout_lottie_loading
}