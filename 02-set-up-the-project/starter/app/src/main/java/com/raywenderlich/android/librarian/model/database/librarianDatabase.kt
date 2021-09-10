package com.raywenderlich.android.librarian.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.ReadingList
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.database.dao.*

const val DataBase_Version = 1

@Database(
    entities = [Book::class, Genre::class, Review::class, ReadingList::class],
    version = DataBase_Version
)
abstract class LibrarianDatabase : RoomDatabase() {


    companion object{
        const val DATABASE_NAME = "librarianDataBase"
        fun createLibrarianDb(context: Context) : LibrarianDatabase{

            return Room.databaseBuilder(context,
            LibrarianDatabase::class.java,
            DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
        }
    }

    abstract fun bookDao():BookDao
    abstract fun genreDao():GenreDao
    abstract fun readListDao():ReadingListDao
    abstract  fun reviewListDao(): ReviewListDao

}