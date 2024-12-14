package com.library.system.payment;

public interface PaymentSystem {
    void processPayment(double amount);
}

class OnlinePayment implements PaymentSystem {
    @Override
    public void processPayment(double amount) {
        // TODO: Логика для онлайн-платежей
        System.out.println("Processing online payment of " + amount);
    }
}

class TerminalPayment implements PaymentSystem {
    @Override
    public void processPayment(double amount) {
        // TODO: Логика для терминальных платежей
        System.out.println("Processing terminal payment of " + amount);
    }
}

class PaymentAdapter {
    private PaymentSystem paymentSystem;

    public PaymentAdapter(String type) {
        if (type.equals("online")) {
            this.paymentSystem = new OnlinePayment();
        } else if (type.equals("terminal")) {
            this.paymentSystem = new TerminalPayment();
        }
    }

    public void pay(double amount) {
        paymentSystem.processPayment(amount);
    }
}
