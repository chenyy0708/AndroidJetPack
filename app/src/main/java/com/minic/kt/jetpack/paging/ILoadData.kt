package com.minic.kt.jetpack.paging

import androidx.paging.ItemKeyedDataSource

/**
 * @ClassName: ILoadData
 * @Description:Paging加载数据
 * @Author: ChenYy
 * @Date: 2019-05-09 13:41
 */
interface ILoadData<T> {
    /**
     * 加载数据，根据实际业务场景实现
     */
    fun loadData(page: Int, rows: Int, callback: ItemKeyedDataSource.LoadCallback<T>)
}