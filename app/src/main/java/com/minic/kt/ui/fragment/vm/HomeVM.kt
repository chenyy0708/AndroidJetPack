package com.minic.kt.ui.fragment.vm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.minic.kt.base.BaseVM
import com.minic.kt.data.model.gank.home.Article
import com.minic.kt.data.model.gank.home.BannerData
import com.minic.kt.ext.awaitResponse
import kotlinx.coroutines.launch

/**
 * @author       :ChenYangYi
 * @date         :2018/09/27/15:50
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class HomeVM(private val typeName: String) : BaseVM() {

    val banners: MutableLiveData<MutableList<BannerData>> = MutableLiveData()
    val article: MutableLiveData<Article> = MutableLiveData()

    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        super.onCreate(lifecycleOwner)
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            getBanner()
            getArticle(1)
        }
    }

    suspend fun getBanner() {
        repository.banners().awaitResponse {
            throwable.value = it
        }?.apply {
            banners.value = this
        }
    }

    suspend fun getArticle(page: Int) {
        repository.article(page).awaitResponse {
            throwable.value = it
        }?.apply {
            article.value = this
        }
    }
}


