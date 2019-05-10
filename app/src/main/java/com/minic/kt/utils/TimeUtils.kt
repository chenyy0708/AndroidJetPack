package com.minic.kt.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class TimeUtils private constructor() {

    private val minute = (60 * 1000).toLong()// 1分钟
    private val hour = 60 * minute// 1小时
    private val day = 24 * hour// 1天
    private val month = 31 * day// 月
    private val year = 12 * month// 年

    private val FORMAT_TYPE = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
    @SuppressLint("SimpleDateFormat")
    private val format = SimpleDateFormat(FORMAT_TYPE)

    companion object {
        private var instance: TimeUtils? = null
            get() {
                if (field == null) {
                    field = TimeUtils()
                }
                return field
            }

        fun get(): TimeUtils {
            return instance!!
        }
    }

    private fun getString2Date(str: String): Date? {
        var date: Date? = null
        try {
            date = format.parse(str)
        } catch (e: Exception) {
            date = null
        }
        return date
    }

    /**
     * 返回文字描述的日期
     * @return
     */
    fun getTimeFormatText(str: String): String? {
        val date = getString2Date(str) ?: return null
        val diff = Date().time - date.time
        var r: Long = 0
        if (diff > year) {
            r = diff / year
            return r.toString() + "年前"
        }
        if (diff > month) {
            r = diff / month
            return r.toString() + "个月前"
        }
        if (diff > day) {
            r = diff / day
            return r.toString() + "天前"
        }
        if (diff > hour) {
            r = diff / hour
            return r.toString() + "个小时前"
        }
        if (diff > minute) {
            r = diff / minute
            return r.toString() + "分钟前"
        }
        return "刚刚"
    }

}
