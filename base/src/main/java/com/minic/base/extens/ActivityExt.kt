package com.minic.base.extens

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * @author       :ChenYangYi
 * @date         :2018/09/29/15:18
 * @description  :Activity 扩展函数
 * @github       :https://github.com/chenyy0708
 */

/**
 * 获取颜色值--扩展函数
 */
fun Activity.getCompactColor(@ColorRes colorRes: Int): Int = ContextCompat.getColor(this, colorRes)

/**
 * dp转px--扩展函数
 */
fun Activity.dpToPx(@DimenRes resID: Int): Int = this.resources.getDimensionPixelOffset(resID)

/**
 * 跳转页面--扩展函数
 */
fun Activity.navigateToActivity(c: Class<*>) {
    val intent = Intent()
    intent.setClass(this, c)
    startActivity(intent)
}

/**
 * 初始化Toolbar
 */
fun AppCompatActivity.initToolbar(mToolbar: Toolbar, mTitle: String = "", isBack: Boolean = true) {
    setSupportActionBar(mToolbar)
    supportActionBar!!.title = mTitle
    supportActionBar!!.setDisplayHomeAsUpEnabled(isBack)
    mToolbar.setNavigationOnClickListener { onBackPressed() }
}

/**
 * 初始化Toolbar
 */
fun Fragment.initToolbar(mToolbar: Toolbar, mTitle: String = "", isBack: Boolean = true) {
    (activity as AppCompatActivity).setSupportActionBar(mToolbar)
    (activity as AppCompatActivity).supportActionBar!!.title = mTitle
    (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(isBack)
}

/**
 * 打印日志--扩展函数
 */
fun Any.logD(tag: String = "GANK_LOG",
             msg: String? = "") {
    Log.d(tag, msg)
}
