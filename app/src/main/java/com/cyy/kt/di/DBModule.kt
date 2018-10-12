package com.cyy.kt.di

import android.arch.persistence.room.Room
import com.cyy.kt.base.App
import com.cyy.kt.model.db.database.BookDatabase
import com.cyy.kt.model.repository.BookRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * @author       :ChenYangYi
 * @date         :2018/10/12/10:19
 * @description  :
 * @github       :https://github.com/chenyy0708
 */

val DB_MODULE_TAG = "DBModule"

val dbModule = Kodein.Module(DB_MODULE_TAG) {

    bind<BookDatabase>() with singleton {
        Room.databaseBuilder(App.INSTANCE, BookDatabase::class.java, "book").build()
    }

    bind<BookRepository>() with singleton {
        BookRepository(BookRepository.BookRemoteDataSource(instance()), BookRepository.BookLocalDataSource(instance()))
    }
}