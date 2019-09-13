package com.minic.kt.ui.fragment.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.minic.kt.base.BaseVM
import com.minic.kt.data.model.gank.home.Article
import com.minic.kt.ext.awaitResponse
import kotlinx.coroutines.launch

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeVM(private val handle: SavedStateHandle) : BaseVM() {
    val article: MutableLiveData<Article> = MutableLiveData()

    val mItems: MutableLiveData<MutableList<Any>> = MutableLiveData()
    private val items = mutableListOf<Any>()

    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        super.onCreate(lifecycleOwner)
        getData()
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
            items.addAll(this)
        }
    }

    suspend fun getArticle() {
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


