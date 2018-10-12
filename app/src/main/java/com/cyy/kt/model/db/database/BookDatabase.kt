package com.cyy.kt.model.db.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.cyy.kt.model.db.dao.BookDao
import com.cyy.kt.model.data.Book

/**
 * @author       :ChenYangYi
 * @date         :2018/10/12/09:48
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
@Database(entities = [Book::class], version = 1)
abstract class BookDatabase : RoomDatabase() {
    abstract fun getBookDao(): BookDao
}