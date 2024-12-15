package com.library.system.user;

import com.library.system.book.Book;
import com.library.system.notifical.NotificationSystem;
import com.library.system.notifical.Observer;
import com.library.system.history.*;

import java.util.List;

public abstract class User implements Observer {
    protected String name;
    protected int maxBooks;  // Максимальное количество книг, которое пользователь может взять
    protected int booksBorrowed;  // Количество книг, которые пользователь уже взял

    protected ActionHistory actionHistory;

    public ActionHistory getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(ActionHistory actionHistory) {
        this.actionHistory = actionHistory;
    }

    public User(String name, int maxBooks) {
        this.name = name;
        this.maxBooks = maxBooks;
        this.booksBorrowed = 0; // Изначально пользователь не взял ни одной книги
        this.actionHistory = new ActionHistory(); //иницилизируем
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
        System.out.println("***Уведомление для " + name + "*** \n" + message);
    }

    // Абстрактный метод для проверки, может ли пользователь взять книгу
    public abstract boolean canBorrow();

    // Метод для того, чтобы пользователь мог забрать книгу
    public void borrowBook(Book book) {
        if (canBorrow()) {
            booksBorrowed++; // Увеличиваем количество взятых книг
            update(name + " забронировал " + book.getDetails());
        } else {
            System.out.println(name + " ты не можешь забрать книгу.");
        }
    }

    // Метод для добавления действия в историю
    public void addAction(String action) {
        actionHistory.addAction(action);
    }

    // Метод для сохранения текущего состояния
    public ActionHistory.HistoryMemento saveActionHistory() {
        return actionHistory.saveState();
    }

    // Метод для восстановления состояния
    public void restoreActionHistory(ActionHistory.HistoryMemento memento) {
        actionHistory.restoreState(memento);
    }
    // Получить количество взятых книг
    public int getBooksBorrowed() {
        return booksBorrowed;
    }
}

