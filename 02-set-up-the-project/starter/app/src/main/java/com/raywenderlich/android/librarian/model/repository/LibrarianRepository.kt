package com.raywenderlich.android.librarian.model.repository

import android.media.Rating
import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.ReadingList
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.relations.BookAndGenre
import com.raywenderlich.android.librarian.model.relations.BookReview
import com.raywenderlich.android.librarian.model.relations.BooksByGenre
import com.raywenderlich.android.librarian.model.relations.ReadingListsWithBooks

interface LibrarianRepository {

    fun getBooks(): List<BookAndGenre>

    fun getGenre():List<Genre>

    fun insertBook(book: Book)

    fun getGenreById(genre : String) : Genre

    fun insertListOfGenre(listGenre : List<Genre>)

    fun deleteBook(book: Book)

    fun updateReview(review: Review)

    fun addReview(review: Review)

    fun addReadingList(readingList: ReadingList)

    fun getReadList():List<ReadingListsWithBooks>

    fun getAllReviews() : List<BookReview>

    fun getBookWithId(bookId: String) : BookAndGenre

    fun getReviewWithId(reviewId:String) : BookReview

    fun removeReadingList(readingList: ReadingList)

    fun removeReview(review: Review)

    fun getAllBooksByGenre(genreId : String) : List<BookAndGenre>

    fun getAllBookByRatings(rating: Int) : List<BookAndGenre>



}