package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String name, String password) {
        return name.equalsIgnoreCase("in28Minutes") && password.equals("dummy");
    }
}
