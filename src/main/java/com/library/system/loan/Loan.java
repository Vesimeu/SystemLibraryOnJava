package com.library.system.loan;

import com.library.system.user.User;
import com.library.system.book.Book;

import java.util.Date;

public class Loan {
    private User user;
    private Book book;

    private Date dueDate;
    private boolean isReturned;
    private LoanState currentState;

    public Loan(User user, Book book) {
        this.user = user;
        this.book = book;
        this.isReturned = false;
        this.currentState = new LoanIssued(); // начальное состояние
    }

    public void setState(LoanState state) {
        this.currentState = state;
    }

    public void returnBook() {
        currentState.handle(this);
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

interface LoanState {
    void handle(Loan loan);
}

class LoanIssued implements LoanState {
    @Override
    public void handle(Loan loan) {
        loan.setReturned(true); // меняем состояние на возвращённое
    }
}

class LoanOverdue implements LoanState {
    @Override
    public void handle(Loan loan) {
        // Логика для просроченной книги
    }
}

class LoanReturned implements LoanState {
    @Override
    public void handle(Loan loan) {
        loan.setReturned(true);
    }
}
