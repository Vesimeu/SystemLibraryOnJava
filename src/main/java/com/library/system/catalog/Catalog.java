package com.library.system.catalog;

import com.library.system.book.Book;

public class Catalog {

    // Метод Factory для создания различных критериев поиска книг
    public SearchCriteria createSearchCriteria(String type) {
        switch (type) {
            case "author":
                return new AuthorSearchCriteria();
            case "title":
                return new TitleSearchCriteria();
            case "year":
                return new YearSearchCriteria();
            default:
                throw new IllegalArgumentException("Invalid search type: " + type);
        }
    }

    // Интерфейс для критериев поиска
    public interface SearchCriteria {
        boolean match(Book book);
    }

    // Пример реализации поиска по автору
    class AuthorSearchCriteria implements SearchCriteria {
        @Override
        public boolean match(Book book) {
            // TODO: Реализовать логику поиска по автору
            return false;
        }
    }

    // Пример реализации поиска по названию
    class TitleSearchCriteria implements SearchCriteria {
        @Override
        public boolean match(Book book) {
            // TODO: Реализовать логику поиска по названию
            return false;
        }
    }

    // Пример реализации поиска по году
    class YearSearchCriteria implements SearchCriteria {
        @Override
        public boolean match(Book book) {
            // TODO: Реализовать логику поиска по году
            return false;
        }
    }
}
