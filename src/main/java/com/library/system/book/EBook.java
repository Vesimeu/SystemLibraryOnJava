package com.library.system.book;

// Электронная книга с дополнительными аттрибутами
public class EBook extends Book {
    private double fileSize; // Размер файла
    private String format; // Формат файла (например, PDF, EPUB)

    public EBook(String title, String author, double fileSize, String format) {
        super(title, author);
        this.fileSize = fileSize;
        this.format = format;
    }

    @Override
    public String getDetails() {
        return "EBook: " + title + " by " + author + ", Size: " + fileSize + "MB, Format: " + format;
    }
    //можно добавить геттеры и сеттеры
}
