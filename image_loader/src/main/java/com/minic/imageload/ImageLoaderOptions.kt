package com.minic.imageload


/**
 * 描述: 图片加载配置类
 * 作者: ChenYy
 * 日期: 2019-10-23 16:05
 */
class ImageLoaderOptions {
    companion object {
        // 没有设置值，默认实现
        const val NORMAL_VALUE = -1
    }

    // 占位图
    var placeHolder = NORMAL_VALUE
    // 加载失败
    var errorHolder = NORMAL_VALUE
    // 跳过内存缓存
    var isSkipMemoryCache = false
    // 跳过磁盘缓存
    var isSkipDiskCache = false
    // 圆形
    var isCircle = false
    // 圆角
    var radius = NORMAL_VALUE
    var topLeftRadius = NORMAL_VALUE
    var topRightRadius = NORMAL_VALUE
    var bottomLeftRadius = NORMAL_VALUE
    var bottomRightRadius = NORMAL_VALUE
}