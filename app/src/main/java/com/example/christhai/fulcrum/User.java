package com.example.christhai.fulcrum;

/**
 * Created by Arvind on 9/29/2017.
 */

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private int passwordHash;
    private int security;
    private String securityAnswer;

    public User(String firstName, String lastName, String email, String password, int security, String securityAnswer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.security = security;
        this.securityAnswer = securityAnswer;
    }
}
