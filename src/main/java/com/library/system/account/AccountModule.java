package com.library.system.account;

public interface AccountModule {
    void authenticate();
    void authorize();
}

class RealAccountModule implements AccountModule {
    @Override
    public void authenticate() {
        // TODO: Реализовать аутентификацию
        System.out.println("Authenticating user...");
    }

    @Override
    public void authorize() {
        // TODO: Реализовать авторизацию
        System.out.println("Authorizing user...");
    }
}

class AccountModuleProxy implements AccountModule {
    private RealAccountModule realAccountModule;

    @Override
    public void authenticate() {
        // TODO: Дополнительная логика проверки прав доступа
        if (realAccountModule == null) {
            realAccountModule = new RealAccountModule();
        }
        realAccountModule.authenticate();
    }

    @Override
    public void authorize() {
        // TODO: Дополнительная логика проверки прав доступа
        if (realAccountModule == null) {
            realAccountModule = new RealAccountModule();
        }
        realAccountModule.authorize();
    }
}
