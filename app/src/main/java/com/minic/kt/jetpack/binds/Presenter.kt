package com.minic.kt.jetpack.binds

import android.view.View

/**
 * 页面描述：Presenter
 */
interface Presenter : View.OnClickListener {
    override fun onClick(v: View?)
}