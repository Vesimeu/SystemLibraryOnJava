package com.library.system.validation;

public class TitleValidator extends BookValidator {
    public boolean validate(String title) {
        if (title.length() < 3) {
            System.out.println("Ошибка: Название слишком короткое. Книга: " + title);
            return false;
        }
        System.out.println("Успешно прошла валидацию на длину книга: " + title );
        return next == null || next.validate(title);
    }
}
