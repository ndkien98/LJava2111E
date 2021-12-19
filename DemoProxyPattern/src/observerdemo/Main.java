package observerdemo;

import observerdemo.observer.Logger;
import observerdemo.observer.Mailer;
import observerdemo.observer.Protector;

public class Main {

    public static void main(String[] args) {
        AccountService account1 = createAccount("contact@gpcoder.com", "127.0.0.1");
        System.out.println("--- show log after login");
        account1.login();
        System.out.println("--- show log after change status");
        account1.changeStatus(LoginStatus.EXPIRED);

        System.out.println("---");
        AccountService account2 = createAccount("contact@gpcoder.com", "116.108.77.231");
        account2.login();
    }

    private static AccountService createAccount(String email, String ip) {
        AccountService account = new AccountService(email, ip);
        account.attach(new Logger());
        account.attach(new Mailer());
        account.attach(new Protector());
        return account;
    }
}
