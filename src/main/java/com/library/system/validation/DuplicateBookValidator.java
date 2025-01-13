package com.library.system.validation;

import com.library.system.library.Library;

public class DuplicateBookValidator extends BookValidator {
    private final Library library;

    public DuplicateBookValidator(Library library) {
        this.library = library;
    }

    @Override
    public boolean validate(String title) {
        boolean exists = library.getBooks().stream()
                .anyMatch(book -> book.getTitle().equalsIgnoreCase(title));

        if (exists) {
            System.out.println("Ошибка: Книга с названием '" + title + "' уже существует.");
            return false;
        }
        System.out.println("Успешно прошло валидацию на уникальность книги: " + title);
        return next == null || next.validate(title);
    }
}