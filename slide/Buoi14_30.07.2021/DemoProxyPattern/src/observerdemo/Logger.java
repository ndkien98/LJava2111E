package observerdemo;

public class Logger implements Observer {

    @Override
    public void update(Account account) {
        System.out.println("Logger: " + account);
    }
}