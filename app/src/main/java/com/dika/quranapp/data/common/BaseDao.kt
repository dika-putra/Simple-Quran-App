package com.dika.quranapp.data.common

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: Collection<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: T)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertIgnore(data: Collection<T>): List<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertIgnore(data: T): Long

    @Update
    fun update(data: T)

    @Update
    fun update(data: Collection<T>)

    @Delete
    fun delete(data: T)
}