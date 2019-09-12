package com.minic.kt

import android.os.Bundle
import com.minic.base.base.BaseActivity
import com.minic.kt.databinding.ActivityMainBinding
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance


class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutRes(): Int = R.layout.activity_main
    override val kodein: Kodein by retainedKodein {
        extend(parentKodein)
        bind<MainActivity>() with instance(this@MainActivity)
    }

    override fun initData(savedInstanceState: Bundle?) {
    }
}


