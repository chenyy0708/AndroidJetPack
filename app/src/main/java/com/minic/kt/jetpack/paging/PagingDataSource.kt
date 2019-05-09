package com.minic.kt.jetpack.paging

import androidx.paging.ItemKeyedDataSource

/**
 * @ClassName: PagingDataSource
 * @Description:提供Paging数据
 * @Author: ChenYy
 * @Date: 2019-05-09 11:57
 */

const val FIRST_PAGE = 1

class PagingDataSource<T>(private val listener: ILoadData<T>) : ItemKeyedDataSource<Int, T>() {

    var page: Int = FIRST_PAGE

    /**
     * 初始化列表数据
     */
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<T>) {
        listener.loadData(FIRST_PAGE, params.requestedLoadSize, callback)
    }

    /**
     * 加载下一页数据
     */
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<T>) {
        listener.loadData(params.key, params.requestedLoadSize, callback)
    }

    /**
     * 加载上一页数据
     */
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<T>) {
    }

    override fun getKey(item: T): Int = page++
}