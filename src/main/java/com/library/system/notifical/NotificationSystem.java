package com.library.system.notifical;

import com.library.system.user.User;
import java.util.ArrayList;
import java.util.List;

public class NotificationSystem {
    private List<Observer> subscribers = new ArrayList<>();

    // Метод для подписки пользователя на уведомления
    public void addSubscriber(User user) {
        subscribers.add(user);
    }

    // Метод для отписки пользователя
    public void removeSubscriber(User user) {
        subscribers.remove(user);
    }

    public static void  notifyThisSubscribers(String message, Observer observer){
        observer.update(message);
    }

    // Метод для отправки уведомлений
    public void notifySubscribers(String message) {
        for (Observer subscriber : subscribers) {
            // Отправляем уведомление всем подписчикам
           subscriber.update(message);
        }
    }
}
