package com.example.GS.java.model;

public class User {

    private String login;
    private String password1;
    private String password2;

    public User() {
    }

    public User( String login, String password1, String password2) {

        this.login = login;
        this.password1 = password1;
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "User{" +

                ", login='" + login + '\'' +
                ", password1='" + password1 + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
