package com.library.system.library;

import com.library.system.loan.Loan;
import com.library.system.notifical.NotificationSystem;
import com.library.system.user.User;
import com.library.system.book.Book;

import java.util.List;
import java.util.ArrayList;

public class Library {
    private static Library instance;
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    private Library() {}

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    // Добавление книги в библиотеку
    public void addBook(Book book) {
        books.add(book);
    }

    // Регистрация пользователя
    public void registerUser(User user) {
        users.add(user);
    }

    // Выдача книги пользователю
    public Loan issueBook(User user, Book book) {
        if (user.canBorrow()) {
            Loan loan = new Loan(user, book);
            loans.add(loan);
            user.borrowBook(book); // Уменьшаем доступные книги пользователя
            user.addAction("Книга выдана пользователю: " + user.getName());//Создаём историю
            notifyObserver("Книга выдана пользователю: " + user.getName(), user);
            return loan;
        } else {
            System.out.println("Пользователь не может взять больше книг.");
            return null;
        }
    }

    // Возврат книги пользователем
    public void returnBook(Loan loan) {
        loan.setReturned(true);
        notifyObserver("Книга возвращена пользователем: " + loan.getUser().getName() , loan.getUser());
        loan.getUser().addAction("Книга возвращена пользователем: " + loan.getUser().getName());
    }

    // Уведомление всех наблюдателей через бибилотику
    public void notifyObserver(String message, User user) {
        NotificationSystem.notifyThisSubscribers(message,user);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", users=" + users +
                ", loans=" + loans +
                '}';
    }

    // Получение списка всех книг в библиотеке
    public List<Book> getBooks() {
        return books;
    }

    // Получение списка всех пользователей
    public List<User> getUsers() {
        return users;
    }

    // Получение всех выданных книг
    public List<Loan> getLoans() {
        return loans;
    }
}
