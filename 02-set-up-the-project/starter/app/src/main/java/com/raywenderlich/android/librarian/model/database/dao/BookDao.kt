package com.raywenderlich.android.librarian.model.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.relations.BookAndGenre


@Dao
interface BookDao {

    @Query("SELECT * FROM Books")
    fun getBooks():List<BookAndGenre>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book : Book)

    @Delete
    fun deleteBook(book: Book)

    @Query("SELECT * FROM Books WHERE id=:bookId")
    fun getBookWithId(bookId:String) : Book

}