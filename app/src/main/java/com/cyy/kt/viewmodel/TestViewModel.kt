package com.cyy.kt.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.cyy.kt.R

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class TestViewModel : ViewModel() {
    val name = ObservableField<String>()
    val error = ObservableInt()


    var url = ObservableField<String>()

    fun getData() {
        name.set("Chen")
        url.set("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=712973186,1318287962&fm=27&gp=0.jpg")
        error.set(R.mipmap.ic_launcher)
    }

}