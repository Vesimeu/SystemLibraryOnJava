package com.library.system.user;

// Профессор - может взять больше книг
public class Professor extends User {

    public Professor(String name) {
        super(name, 5);  // Профессор может взять максимум 5 книг
    }

    @Override
    public boolean canBorrow() {
        // Профессор может брать книги, если не превысил лимит
        return booksBorrowed < maxBooks;
    }
}
