package com.minic.kt.jetpack.paging

import androidx.lifecycle.LiveData
import androidx.paging.ItemKeyedDataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

/**
 * @ClassName: PagingLoadHelper
 * @Description:Paging初始化简化函数
 * @Author: ChenYy
 * @Date: 2019-05-09 16:08
 */

fun <T> loadData(callback: (page: Int, rows: Int, callback: ItemKeyedDataSource.LoadCallback<T>) -> Unit): LiveData<PagedList<T>> {
    return LivePagedListBuilder(PagingDataSourceFactory(object : ILoadData<T> {
        override fun loadData(page: Int, rows: Int, callback: ItemKeyedDataSource.LoadCallback<T>) {
            callback(page, rows, callback)
        }
    }), PagedList.Config.Builder()
            .setPageSize(10)                         //配置分页加载的数量
            .setEnablePlaceholders(false)     //配置是否启动PlaceHolders
            .setInitialLoadSizeHint(10)              //初始化加载的数量
            .build())
            .build()
}