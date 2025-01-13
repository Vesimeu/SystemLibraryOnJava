package com.library.system.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TrackChange {
    String message() default "Изменение данных";
}
