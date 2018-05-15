package com.example.test.services.authentification;

public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);

}
