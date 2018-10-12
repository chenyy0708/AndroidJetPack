package com.cyy.kt.model.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

/**
 * @author       :ChenYangYi
 * @date         :2018/07/25/14:14
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
@Entity(tableName = "book")
data class Book(
        @PrimaryKey(autoGenerate = true)
        @NonNull
        var id: Int,
        @ColumnInfo(name = "alt")
        var alt: String,
        @ColumnInfo(name = "publisher")
        var publisher: String,
        @ColumnInfo(name = "image")
        var image: String)