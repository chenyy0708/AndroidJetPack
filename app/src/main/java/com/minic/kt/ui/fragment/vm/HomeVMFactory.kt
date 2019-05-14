package com.minic.kt.ui.fragment.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @ClassName: HomeVMFactory
 * @Description:传递参数到ViewModel
 * @Author: ChenYy
 * @Date: 2019-05-14 17:03
 */
class HomeVMFactory(private val typeName: String) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeVM(typeName) as T
    }
}