package com.minic.kt.databinding.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.minic.base.extens.logD
import com.minic.kt.base.BaseVM
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeVM : BaseVM() {
    val name = MutableLiveData<String>()
    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        super.onCreate(lifecycleOwner)
        chapters()
    }

    private fun chapters() {
        GlobalScope.launch {
            logD("线程:${Thread.currentThread().name}", tag = "HomeVM")
            // 在后台启动一个新的协程并继续
            val request = douBanService.chaptersAsync()
            delay(3000L)// 非阻塞的等待 3 秒钟
            try {
                val response = request.await()
                name.postValue(response.data[0].name)
            } catch (e: HttpException) {
            } catch (e: Throwable) {
                throwable.value = e
            }
        }
        // 协程已在等待时主线程还在继续
        logD("开始阻塞")
        runBlocking {
            logD("线程:${Thread.currentThread().name}", tag = "HomeVM")
            // 但是这个表达式阻塞了主线程
            delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
        }
        logD("继续运行")
    }

}