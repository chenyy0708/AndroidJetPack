package com.minic.kt.ui.fragment.vm

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

/**
 * @ClassName: HomeVMFactory
 * @Description:传递参数到ViewModel
 * @Author: ChenYy
 * @Date: 2019-05-14 17:03
 */
@Suppress("UNCHECKED_CAST")
class HomeVMFactory(
        owner: SavedStateRegistryOwner,
        defaultArgs: Bundle? = null) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        return HomeVM(handle) as T
    }

}