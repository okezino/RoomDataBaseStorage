package com.raywenderlich.android.librarian.model.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.relations.BooksByGenre

@Dao
interface GenreDao {

    @Query("SELECT * FROM Genre")
    fun getAllGenre():List<Genre>

    @Query("SELECT * FROM Genre WHERE id = :genreId")
    fun getGenreWithId(genreId:String): Genre

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addListOfGenre(listOfGenre : List<Genre>)

    @Transaction
    @Query("SELECT * FROM Genre WHERE id=:genreId")
    fun getAllBooksByGenre(genreId: String) : BooksByGenre
}