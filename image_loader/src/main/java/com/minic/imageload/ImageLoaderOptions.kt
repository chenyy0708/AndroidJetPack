package com.minic.imageload

import android.graphics.Color


/**
 * 描述: 图片加载配置类
 * 作者: ChenYy
 * 日期: 2019-10-23 16:05
 */
class ImageLoaderOptions {
    companion object {
        // 没有设置值，默认实现
        const val NORMAL_VALUE = -1
        const val CENTER_CROP = 0
        const val FIT_CENTER = 1
    }


    // 占位图
    var placeHolder = NORMAL_VALUE
    // 加载失败
    var errorHolder = NORMAL_VALUE
    // 缩放类型
    var scaleType = NORMAL_VALUE
    // 跳过内存缓存
    var isSkipMemoryCache = false
    // 跳过磁盘缓存
    var isSkipDiskCache = false
    // 圆形
    var isCircle = false
    var borderSize = 0
    var borderColor = Color.TRANSPARENT
    // 圆角
    var radius = 0
    var topLeftRadius = 0
    var topRightRadius = 0
    var bottomLeftRadius = 0
    var bottomRightRadius = 0
}