package observerdemo;

public class Mailer implements Observer {

    @Override
    public void update(Account account) {
        if (account.getStatus() == LoginStatus.EXPIRED) {
            System.out.println("Mailer: Account " + account.getEmail() + " is expired. An email was sent!");
        }
    }
}