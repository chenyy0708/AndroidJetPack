package com.cyy.kt.model.repository

import com.cyy.kt.model.data.Book
import com.cyy.kt.model.db.database.BookDatabase
import com.cyy.kt.model.remote.api.DouBanService
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

/**
 * @author       :ChenYangYi
 * @date         :2018/10/12/11:09
 * @description  :图片仓储，负责分别从本地Room和网络获取数据
 * @github       :https://github.com/chenyy0708
 */
class BookRepository(
        private val remoteDataSource: BookRemoteDataSource,
        private val localDataSource: BookLocalDataSource
) {


    fun getRemoteBook(id: Int): Flowable<Book> {
        return remoteDataSource.getBook(id)
//                .flatMap {
////                    localDataSource.saveBook(it)  // save book
//                            .andThen(Flowable.just(it))
//                }
    }

    fun getLocalBook(id: Int): Flowable<Book> {
        return localDataSource.getBook(id)
    }

    class BookRemoteDataSource(
            private val douBanService: DouBanService
    ) {

        fun getBook(id: Int): Flowable<Book> =
                douBanService
                        .getDouBanBook()
                        .subscribeOn(Schedulers.io())
    }

    class BookLocalDataSource(
            private val bookDatabase: BookDatabase
    ) {
        fun saveBook(book: Book): Completable =
                Completable.fromAction {
                    bookDatabase.getBookDao().insert(book)
                }

        fun getBook(id: Int): Flowable<Book> = bookDatabase.getBookDao().getBook(id)
    }
}