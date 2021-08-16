package com.danchoo.date.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "category")
data class Category(
    @PrimaryKey
    val hash: String = UUID.randomUUID().toString(),

    val title: String = "",

    val contents: String = "",

    val timestamp: Long = 0L,

    var revision : Long = 0
) {
}