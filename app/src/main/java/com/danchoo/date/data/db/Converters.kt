package com.danchoo.date.data.db

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


class Converters {

    @TypeConverter
    fun toStringLongList(value: String?): List<Long> {
        return if (value.isNullOrEmpty()) {
            ArrayList()
        } else {
            val moshi = Moshi.Builder().build()
            val listMyData = Types.newParameterizedType(
                List::class.java,
                Long::class.java
            )

            val adapter: JsonAdapter<List<Long>> = moshi.adapter(listMyData)
            adapter.fromJson(value) ?: emptyList()
        }
    }

    @TypeConverter
    fun fromLongList(list: List<Long>): String {
        return if (list.isEmpty()) {
            ""
        } else {
            val moshi = Moshi.Builder().build()
            val listMyData = Types.newParameterizedType(
                List::class.java,
                Long::class.java
            )

            val adapter: JsonAdapter<List<Long>> = moshi.adapter(listMyData)
            adapter.toJson(list)
        }
    }
}