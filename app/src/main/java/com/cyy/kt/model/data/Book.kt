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
data class  Book(
        var id: Int,
        var alt: String,
        var publisher: String,
        var image: String)