package com.raywenderlich.android.librarian.model.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.ReadingList

@Dao
interface ReadingListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addReadingList(readingList: ReadingList)

    @Query("SELECT * FROM ReadingList")
    fun getAllReadingList(): List<ReadingList>

    @Delete
    fun removeReadingList(readingList: ReadingList)




}