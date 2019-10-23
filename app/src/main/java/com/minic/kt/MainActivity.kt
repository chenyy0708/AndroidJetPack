package com.minic.kt

import android.os.Bundle
import com.minic.base.base.BaseActivity
import com.minic.kt.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun initData(savedInstanceState: Bundle?) {
    }
}


