package com.raywenderlich.android.librarian.model.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.relations.BookReview

@Dao
interface ReviewListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addReview(review: Review)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateReview(review: Review)

    @Query("SELECT * FROM Review")
    fun getAllReview(): List<BookReview>

    @Delete
    fun removeReview(review: Review)

    @Query("SELECT * FROM Review WHERE id=:reviewId")
    fun getReview(reviewId: String) : BookReview

    @Query("SELECT * FROM Review WHERE rating=:ratings" )
    fun getBookReviewByRating(ratings : Int) : List<BookReview>
}