package com.minic.base.extens

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import java.util.concurrent.Executor
import java.util.concurrent.Executors


/**
 * 描述: 方便子线程主线程切换任务
 * 作者: ChenYy
 * 日期: 2019-10-28 11:24
 */

// 管理Activity/Fragment 和 对应的 LifecycleObserver
internal val threadLifecycleMap = hashMapOf<LifecycleOwner, TreadLifecycleObserver>()

// 子线程 线程池
internal val executorService by lazy {
    Executors.newCachedThreadPool()
}

// 主线程
internal val mainThreadExecutor by lazy {
    MainThreadExecutor()
}

// 获取当前Activity/Fragment对应的TreadLifecycleObserver
internal fun getTreadObserver(owner: LifecycleOwner): TreadLifecycleObserver {
    var observer: TreadLifecycleObserver?
    if (threadLifecycleMap.containsKey(owner)) {
        observer = threadLifecycleMap[owner]
        if (observer != null) {
            return observer
        }
    }
    observer = TreadLifecycleObserver(owner)
    threadLifecycleMap[owner] = observer
    return observer
}

// 主线程Handler
class MainThreadExecutor : Executor {
    private val handler = Handler(Looper.getMainLooper())

    override fun execute(r: Runnable) {
        handler.post(r)
    }
}

// 监听Activity/Fragment的生命周期
open class TreadLifecycleObserver(private val lifecycleOwner: LifecycleOwner) : LifecycleObserver {

    var isActive = true

    init {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
        isActive = false
        lifecycleOwner.lifecycle.removeObserver(this)
        threadLifecycleMap.remove(lifecycleOwner)
    }
}

// 开启子线程任务
fun LifecycleOwner.launch(block: TreadLifecycleObserver.() -> Unit) {
    val observer = getTreadObserver(this)
    val runnable = Runnable {
        block(observer)
    }
    executorService.execute(runnable)
}

// 运行在UI线程的扩展函数
fun TreadLifecycleObserver.uiThread(block: () -> Unit) {
    val runnable = Runnable {
        block()
    }
    if (isActive) { // 防止内存泄露和View空指针
        mainThreadExecutor.execute(runnable)
    }
}