package com.example.quizus;

public class user {

    private String name, email, pass;
    private int coinPoints;

    public user() {
    }

    public user(String name, String email, String pass, int coinPoints) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.coinPoints = coinPoints;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getCoinPoints() {
        return coinPoints;
    }

    public void setCoinPoints(int coinPoints) {
        this.coinPoints = coinPoints;
    }
}
