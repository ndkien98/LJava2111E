package observerdemo;

import java.util.ArrayList;
import java.util.List;

enum LoginStatus {
    SUCCESS, FAILURE, INVALID, EXPIRED
}

public class AccountService implements Subject {

    private Account account;
    private List<Observer> observers = new ArrayList<>();

    public AccountService(String email,String ip){
        account = new Account();
        account.setEmail(email);
        account.setIp(ip);
    }


    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer:observers
             ) {
            observer.update(account);
        }
    }

    public void changeStatus(LoginStatus status){
        account.setStatus(status);
        System.out.println("Status is changed");
        this.notifyAllObserver();
    }

    public void login(){
        if (!this.isValidIP()){
            account.setStatus(LoginStatus.INVALID);
        }else if (this.isValidEmail()){
            account.setStatus(LoginStatus.SUCCESS);
        } else {
            account.setStatus(LoginStatus.FAILURE);
        }
        System.out.println("Login is handled");
        this.notifyAllObserver();

    }

    private boolean isValidIP() {
        return "127.0.0.1".equals(account.getIp());
    }

    private boolean isValidEmail() {
        return "kiennd@gamil.com".equalsIgnoreCase(account.getEmail());
    }
}
