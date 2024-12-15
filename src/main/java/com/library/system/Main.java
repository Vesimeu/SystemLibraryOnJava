package com.library.system;

import com.library.system.book.*;
import com.library.system.library.Library;
import com.library.system.loan.Loan;
import com.library.system.user.*;
import com.library.system.notifical.NotificationSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем библиотеку
        Library library = Library.getInstance();

        // Создаем книги
        EBook ebook = new EBook("Java Programming", "John Doe", 5.0, "PDF");
        PrintedBook printedBook = new PrintedBook("Physics Fundamentals", "Jane Smith", "Shelf A3");
        Magazine magazine = new Magazine("Tech Trends", "Alex Brown", 12, "December 2024");
        EBook ebookWithMetadata = new EBook("Advanced Java", "John Doe", 10.0, "EPUB");
        EBookWithMetadata ebookWithMetadataDecorator = new EBookWithMetadata(ebookWithMetadata, "Published in 2024");
        Book bookWithReview = new BookWithReview(ebook, "Great resource for learning Java.");

        // Добавляем книги в библиотеку
        library.addBook(ebook);
        library.addBook(printedBook);
        library.addBook(magazine);
        library.addBook(ebookWithMetadata);
        library.addBook(bookWithReview);

        // Создаем пользователей
        User student = new Student("Студент Колян");
        User professor = new Professor("Профессор Крокодил Гена");
        User librarian = new Librarian("Библиотекарь Человек паук");
        List<User> users = new ArrayList<>();
        users.add(student);users.add(professor);users.add(librarian);

        // Регистрируем пользователей в библиотеке
        library.registerUser(student);
        library.registerUser(professor);
        library.registerUser(librarian);

        // Создаем систему уведомлений
        NotificationSystem notificationSystem = new NotificationSystem();

        // Подписываем пользователей на уведомления
        notificationSystem.addSubscriber(student);
        notificationSystem.addSubscriber(professor);
        notificationSystem.addSubscriber(librarian);

        // Пользователи берут книги
        Loan studentLoan = library.issueBook(student, ebook);  // Студент берет книгу
        Loan professorLoan = library.issueBook(professor, printedBook);  // Профессор берет книгу
        Loan librarianLoan = library.issueBook(librarian, magazine);  // Библиотекарь берет журнал

        // Возврат книги
        library.returnBook(studentLoan);  // Студент возвращает книгу
        library.returnBook(professorLoan);  // Профессор возвращает книгу

        // Отправка уведомлений
        //notificationSystem.notifySubscribers("***Отправим уведомление всем подписчикам***'");

        //История событий пользователей
        users.stream()
                .forEach(user -> {
                    //Выведем историю и сохраним её.
                    user.getActionHistory().getActions().stream().forEach(list -> System.out.println(list));
                    user.saveActionHistory();
                });

    }
}
