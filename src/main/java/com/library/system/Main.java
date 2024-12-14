package com.library.system;

import com.library.system.book.*;
import com.library.system.book.EBook;
import com.library.system.book.PrintedBook;
import com.library.system.library.Library;
import com.library.system.user.*;

public class Main {
    public static void main(String[] args) {
        Library library;
        EBook ebook = new EBook("Java Programming", "John Doe", 5.0, "PDF");
        PrintedBook printedBook = new PrintedBook("Physics Fundamentals", "Jane Smith", "Shelf A3");
        Magazine magazine = new Magazine("Tech Trends", "Alex Brown", 12, "December 2024");
        EBook ebookWithMetadata = new EBook("Advanced Java", "John Doe", 10.0, "EPUB");
        EBookWithMetadata ebookWithMetadataDecorator = new EBookWithMetadata(ebookWithMetadata, "Published in 2024");
        Book bookWithReview = new BookWithReview(ebook, "Great resource for learning Java.");
        // Создаем пользователей
        Student student = new Student("Alice");
        Professor professor = new Professor("Dr. Smith");
        Librarian librarian = new Librarian("John Librarian");

    }
}