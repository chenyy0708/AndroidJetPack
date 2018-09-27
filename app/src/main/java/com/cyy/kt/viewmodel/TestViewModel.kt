package com.cyy.kt.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class TestViewModel : ViewModel() {
    val name = ObservableField<String>()


    fun getData() {
        name.set("S")
    }

}