package com.library.system.validation;

public abstract class BookValidator {
    protected BookValidator next;

    public BookValidator linkWith(BookValidator next) {
        this.next = next;
        return next;
    }

    public abstract boolean validate(String title);
}