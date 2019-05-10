package com.minic.kt.utils.ext

import android.widget.ImageView
import com.minic.kt.R
import com.pingerx.imagego.core.strategy.loadRound

/**
 * @ClassName: ImageLoader
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-10 15:16
 */

fun ImageView.loadImage(any: Any?, radius: Int = 0) {
    if (radius > 0) {
        loadRound(any, this, radius)
    } else {
        com.pingerx.imagego.core.strategy.loadImage(any, this, placeHolder = R.mipmap.ic_launcher_round, errorHolder = R.mipmap.ic_launcher_round)
    }
}