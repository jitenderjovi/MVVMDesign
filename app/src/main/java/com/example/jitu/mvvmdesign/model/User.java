package com.example.jitu.mvvmdesign.model;

/**
 * Created by Jitu on 17/02/17.
 */

public class User {
    public final String email;
    public final String password;
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }

    private void hitloginAPI(){

    }

}
