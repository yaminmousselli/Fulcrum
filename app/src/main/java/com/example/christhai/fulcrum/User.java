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
    /*
    public class Post {

    public String uid;
    public String author;
    public String title;
    public String body;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<String, Boolean>();

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String uid, String author, String title, String body) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.body = body;
    }
}
     */
}
