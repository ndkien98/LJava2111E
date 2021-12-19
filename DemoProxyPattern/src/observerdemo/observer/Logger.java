package observerdemo.observer;

import observerdemo.Observer;
import observerdemo.User;

public class Logger implements Observer {

    @Override
    public void update(User user) {
        System.out.println("Logger: " + user);
    }
}