package com.cyy.kt.model.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.cyy.kt.model.data.Book
import io.reactivex.Flowable

/**
 * @author       :ChenYangYi
 * @date         :2018/10/12/09:42
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
@Dao
interface BookDao {
    @Insert
    fun insert(book: Book)

    @Query("SELECT * FROM book WHERE id = :bookId")
    fun getBook(bookId: Int): Flowable<Book>
}