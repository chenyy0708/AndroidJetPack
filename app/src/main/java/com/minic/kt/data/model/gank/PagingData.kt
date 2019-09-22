package com.minic.kt.data.model.gank

data class PagingData<T>(val curPage: Int,
                         var pageCount: Int,
                         val total: Int,
                         val offset: Int,
                         val datas: MutableList<T>)