package com.t3h.demospringsecurity.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {


    public String encrytedPassword(String password){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public static void main(String[] args) {

        EncrytedPasswordUtils encrytedPasswordUtils = new EncrytedPasswordUtils();
        String pass = "user";
        System.out.println(encrytedPasswordUtils.encrytedPassword(pass));
    }
}
