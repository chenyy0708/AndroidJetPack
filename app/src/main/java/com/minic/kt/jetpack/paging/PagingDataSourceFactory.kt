package com.minic.kt.jetpack.paging

import androidx.paging.DataSource

/**
 * @ClassName: PagingDataSourceFactory
 * @Description:Paging数据
 * @Author: ChenYy
 * @Date: 2019-05-09 11:56
 */
class PagingDataSourceFactory<T>(private val listener: ILoadData<T>) : DataSource.Factory<Int, T>() {
    override fun create(): DataSource<Int, T> {
        return PagingDataSource(listener)
    }
}