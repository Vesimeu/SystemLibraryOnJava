package com.library.system.user;

import com.library.system.book.Book;
import com.library.system.notifical.Observer;

public abstract class User implements Observer {
    protected String name;
    protected int maxBooks;  // Максимальное количество книг, которое пользователь может взять
    protected int booksBorrowed;  // Количество книг, которые пользователь уже взял

    public User(String name, int maxBooks) {
        this.name = name;
        this.maxBooks = maxBooks;
        this.booksBorrowed = 0; // Изначально пользователь не взял ни одной книги
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        // Логика обработки уведомлений для каждого типа пользователя
        System.out.println(name + " received notification: " + message);
    }

    // Абстрактный метод для проверки, может ли пользователь взять книгу
    public abstract boolean canBorrow();

    // Метод для того, чтобы пользователь мог забрать книгу
    public void borrowBook(Book book) {
        if (canBorrow()) {
            booksBorrowed++; // Увеличиваем количество взятых книг
            System.out.println(name + " borrowed " + book.getDetails());
        } else {
            System.out.println(name + " cannot borrow more books.");
        }
    }

    // Получить количество взятых книг
    public int getBooksBorrowed() {
        return booksBorrowed;
    }
}

