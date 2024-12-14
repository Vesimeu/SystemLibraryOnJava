package com.library.system.book;

public class BookCopy implements Cloneable {
    private Book book;
    private String copyId;

    public BookCopy(Book book, String copyId) {
        this.book = book;
        this.copyId = copyId;
    }

    // Метод для клонирования экземпляра книги
    @Override
    public BookCopy clone() {
        try {
            return (BookCopy) super.clone();  // Это позволит клонировать объект
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;  // В случае ошибки клонирования
        }
    }

    public String getDetails() {
        return book.getDetails() + " (Copy ID: " + copyId + ")";
    }

    public Book getBook() {
        return book;
    }

    public String getCopyId() {
        return copyId;
    }
}
