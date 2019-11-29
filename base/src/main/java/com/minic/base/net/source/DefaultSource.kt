package com.minic.base.net.source

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent


/**
 * 描述: 适用于App内多个请求数据共用，类似用户信息多个地方需要刷新等操作
 * 作者: ChenYy
 * 日期: 2019-11-28 17:51
 */
abstract class DefaultSource<T>(private val lifecycleOwner: LifecycleOwner) : ISourceRequest<T> {

    private val remoteSource by lazy {
        createRemoteSource(lifecycleOwner)
    }

    private val localSource by lazy {
        createLocalSource("AnalysisSource", lifecycleOwner as Context)
    }

    protected val mEventBus by lazy {
        if (lifecycleOwner !is Context) {
            throw IllegalArgumentException("lifecycleOwner must be Context")
        }
//        EventBusManager(lifecycleOwner as Context)
    }

    init {
        if (lifecycleOwner !is Context) {
            throw IllegalArgumentException("lifecycleOwner must be Context")
        }
        lifecycleOwner.lifecycle.addObserver(this)
//        lifecycleOwner.lifecycle.addObserver(mEventBus)
//        registerEvent(mEventBus)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        lifecycleOwner.lifecycle.removeObserver(this)
//        lifecycleOwner.lifecycle.removeObserver(mEventBus)
    }

    protected var block: (response: T) -> Unit = {}

    override fun getResponse() {
        localSource.getResponse()
    }

    override fun refreshData() {
        remoteSource.getResponse()
    }

    protected abstract fun createRemoteSource(lifecycleOwner: LifecycleOwner): IDataSource
    protected abstract fun createLocalSource(sourceKey: String, context: Context): IDataSource

//    abstract fun registerEvent(eventBusManager: EventBusManager)

    fun register(block: (response: T) -> Unit) {
        this.block = block
    }
}