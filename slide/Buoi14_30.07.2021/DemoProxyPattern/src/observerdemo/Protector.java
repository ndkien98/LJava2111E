package observerdemo;

public class Protector implements Observer {

    @Override
    public void update(Account account) {
        if (account.getStatus() == LoginStatus.INVALID) {
            System.out.println("Protector: Account " + account.getEmail() + " is invalid. "
                    + "IP " + account.getIp() + " is blocked");
        }
    }
}