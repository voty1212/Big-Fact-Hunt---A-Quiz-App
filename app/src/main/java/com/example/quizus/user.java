package com.example.quizus;

public class user {

    private String name, email, pass, referCode;
    private int coinPoints;

    public user() {
    }

    public user(String name, String email, String pass, String referCode, int coinPoints) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.referCode = referCode;
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

    public String getReferCode() {
        return referCode;
    }

    public void setReferCode(String referCode) {
        this.referCode = referCode;
    }

    public int getCoinPoints() {
        return coinPoints;
    }

    public void setCoinPoints(int coinPoints) {
        this.coinPoints = coinPoints;
    }
}
