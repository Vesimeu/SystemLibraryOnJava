package com.library.system.book;

public abstract class Book {
    protected String title;
    protected String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Метод для получения описания книги
    public abstract String getDetails();
}

