package com.library.system.book;

// Журнал с выпуском и датой публикации
public class Magazine extends Book {
    private int issue; // Номер выпуска
    private String publicationDate; // Дата публикации

    public Magazine(String title, String author, int issue, String publicationDate) {
        super(title, author);
        this.issue = issue;
        this.publicationDate = publicationDate;
    }

    @Override
    public String getDetails() {
        return "Magazine: " + title + " by " + author + ", Issue: " + issue + ", Publication Date: " + publicationDate;
    }
}
