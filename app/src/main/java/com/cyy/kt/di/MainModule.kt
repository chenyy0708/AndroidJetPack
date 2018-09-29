package com.cyy.kt.di

import com.cyy.base.extens.addLifecycle
import com.cyy.base.extens.getInjectViewModel
import com.cyy.kt.MainActivity
import com.cyy.kt.viewmodel.TestViewModel
import org.kodein.di.Kodein
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

val MAIN_MODULE_TAG = "MAIN_MODULE_TAG"

val mainModule = Kodein.Module(MAIN_MODULE_TAG) {

    /**
     * scoped(AndroidComponentsWeakScope)
     * 保证了Activity级别的局部单例
     */
    bind<TestViewModel>() with scoped(AndroidComponentsWeakScope).singleton {
        // 得到ViewModel实例
        instance<MainActivity>().getInjectViewModel(TestViewModel::class.java).apply {
            // 绑定生命周期
//            addLifecycle(instance<MainActivity>())
        }
    }

}
