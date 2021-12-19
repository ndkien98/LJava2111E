package observerdemo.observer;

import observerdemo.LoginStatus;
import observerdemo.Observer;
import observerdemo.User;

public class Mailer implements Observer {

    @Override
    public void update(User user) {
        if (user.getStatus() == LoginStatus.EXPIRED) {
            System.out.println("Mailer: User " + user.getEmail() + " is expired. An email was sent!");
        }
    }
}