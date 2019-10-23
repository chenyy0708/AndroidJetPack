package com.minic.imageload


/**
 * 描述: 图片加载配置类
 * 作者: ChenYy
 * 日期: 2019-10-23 16:05
 */
class ImageLoaderOptions {
    companion object {
        const val NORMAL_VALUE = -1
    }

    var placeHolder = NORMAL_VALUE
    var errorHolder = NORMAL_VALUE
    var isSkipMemoryCache = false
    var isSkipDiskCache = false
    var isCircle = false
    var radius = NORMAL_VALUE
    var topLeftRadius = NORMAL_VALUE
    var topRightRadius = NORMAL_VALUE
    var bottomLeftRadius = NORMAL_VALUE
    var bottomRightRadius = NORMAL_VALUE
}