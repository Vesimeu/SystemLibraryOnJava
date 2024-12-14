package com.library.system.book;

// Декоратор для добавления рецензии к книге
public class BookWithReview extends Book {
    protected Book book;
    private String review;

    public BookWithReview(Book book, String review) {
        super(book.title, book.author);
        this.book = book;
        this.review = review;
    }

    @Override
    public String getDetails() {
        return book.getDetails() + ", Review: " + review;
    }
}
