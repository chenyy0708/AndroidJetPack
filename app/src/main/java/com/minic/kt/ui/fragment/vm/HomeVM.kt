package com.minic.kt.ui.fragment.vm

import androidx.paging.ItemKeyedDataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.minic.base.extens.logD
import com.minic.kt.base.BaseVM
import com.minic.kt.data.model.gank.Android
import com.minic.kt.ext.awaitV2Response
import com.minic.kt.jetpack.paging.ILoadData
import com.minic.kt.jetpack.paging.PagingDataSourceFactory
import kotlinx.coroutines.launch

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeVM : BaseVM() {
    var mList = LivePagedListBuilder(PagingDataSourceFactory(object : ILoadData<Android> {
        override fun loadData(page: Int, rows: Int, callback: ItemKeyedDataSource.LoadCallback<Android>) {
            logD(msg = "加载第${page}页数据")
            coroutine.launch {
                gankRepository.androidListAsync(page, rows).awaitV2Response {
                    throwable.value = it
                }?.apply {
                    callback.onResult(this)
                }
            }
        }
    }), PagedList.Config.Builder()
            .setPageSize(10)                         //配置分页加载的数量
            .setEnablePlaceholders(false)     //配置是否启动PlaceHolders
            .setInitialLoadSizeHint(10)              //初始化加载的数量
            .build())
            .build()
}


