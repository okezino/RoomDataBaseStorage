package com.raywenderlich.android.librarian.model.repository

import android.util.Log
import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.ReadingList
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.database.dao.BookDao
import com.raywenderlich.android.librarian.model.database.dao.GenreDao
import com.raywenderlich.android.librarian.model.database.dao.ReadingListDao
import com.raywenderlich.android.librarian.model.database.dao.ReviewListDao
import com.raywenderlich.android.librarian.model.relations.BookAndGenre
import com.raywenderlich.android.librarian.model.relations.BookReview
import com.raywenderlich.android.librarian.model.relations.BooksByGenre
import com.raywenderlich.android.librarian.model.relations.ReadingListsWithBooks

class LibrarianRepositoryImpl(
    val bookDao: BookDao,
    val genreDao: GenreDao,
    val readListDao: ReadingListDao,
    val reviewListDao: ReviewListDao
) : LibrarianRepository {

    override fun getBooks(): List<BookAndGenre> {

        return bookDao.getBooks()
    }

    override fun getGenre(): List<Genre> {
        return genreDao.getAllGenre()
    }

    override fun insertBook(book: Book) {
        bookDao.insertBook(book)
    }

    override fun getGenreById(genre: String): Genre {
        return genreDao.getGenreWithId(genre)
    }

    override fun insertListOfGenre(listGenre: List<Genre>) {
        genreDao.addListOfGenre(listGenre)
    }

    override fun deleteBook(book: Book) {
        bookDao.deleteBook(book)
    }

    override fun updateReview(review: Review) {
        reviewListDao.updateReview(review)

    }

    override fun addReview(review: Review) {
        reviewListDao.addReview(review)
        Log.d("Repository", "seen")
    }

    override fun addReadingList(readingList: ReadingList) {
        readListDao.addReadingList(readingList = readingList)
    }

    override fun getReadList(): List<ReadingListsWithBooks> {
        return readListDao.getAllReadingList().map {
            ReadingListsWithBooks(it.id, it.name, emptyList())
        }
    }

    override fun getAllReviews(): List<BookReview> {
        return reviewListDao.getAllReview()
    }

    override fun getBookWithId(bookId: String): BookAndGenre {
        var res = bookDao.getBookWithId(bookId)
        return BookAndGenre(res, genreDao.getGenreWithId(res.id))
    }

    override fun getReviewWithId(reviewId: String): BookReview {
        return reviewListDao.getReview(reviewId)
    }

    override fun removeReadingList(readingList: ReadingList) {
        readListDao.removeReadingList(readingList)
    }

    override fun removeReview(review: Review) {
        reviewListDao.removeReview(review)
    }

    override fun getAllBooksByGenre(genreId: String): List<BookAndGenre> {
        genreDao.getAllBooksByGenre(genreId).let { BookByGenre ->
            var books = BookByGenre.books ?: return emptyList()
            return books.map { BookAndGenre(it, getGenreById(it.genreId)) }
        }
    }

    override fun getAllBookByRatings(rating: Int): List<BookAndGenre> {

      val res =   reviewListDao.getBookReviewByRating(rating)
      return res.map {
          BookAndGenre(it.book, getGenreById(it.book.genreId))
      }
    }


}