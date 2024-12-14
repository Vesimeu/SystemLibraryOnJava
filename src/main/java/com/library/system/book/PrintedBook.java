package com.library.system.book;

// Печатная книга с местоположением на полке
public class PrintedBook extends Book {
    private String locationOnShelf;

    public PrintedBook(String title, String author, String locationOnShelf) {
        super(title, author);
        this.locationOnShelf = locationOnShelf;
    }

    @Override
    public String getDetails() {
        return "Printed Book: " + title + " by " + author + ", Shelf Location: " + locationOnShelf;
    }
}
