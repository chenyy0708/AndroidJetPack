package com.minic.kt.ui.fragment.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minic.base.databinding.viewmodel.SingleLiveEvent
import com.minic.kt.base.BaseVM
import com.minic.kt.data.model.gank.home.Article
import com.minic.kt.ext.awaitResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.kodein.di.android.subKodein

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeVM : BaseVM() {
    val article: MutableLiveData<Article> = SingleLiveEvent()
    val isRefreshData: MutableLiveData<Boolean> = SingleLiveEvent()

    val mItems: MutableLiveData<MutableList<Any>> = SingleLiveEvent()
    private val items = mutableListOf<Any>()

    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        super.onCreate(lifecycleOwner)
        if (!isInit) {
            isRefreshData.value = true
            getData()
        }
    }

    fun getData() {
        items.clear()
        viewModelScope.launch {
            getBanner()
            getArticleTop()
            getArticle()
        }
    }

    private suspend fun getBanner() {
        repository.banners().awaitResponse {
            throwable.value = it
        }?.apply {
            items.add(this)
        }
    }

    private suspend fun getArticleTop() {
        repository.articleTop().awaitResponse {
            throwable.value = it
        }?.apply {
            // 置顶数据
            forEach { it.isTopping = true }
            items.addAll(this)
        }
    }

    private suspend fun getArticle() {
        repository.article(0).awaitResponse {
            throwable.value = it
        }?.apply {
            items.addAll(this.datas)
            mItems.value = items
        }
    }

    fun getArticle(page: Int) {
        viewModelScope.launch {
            repository.article(page).awaitResponse {
                throwable.value = it
            }?.apply {
                article.value = this
            }
        }
    }
}


