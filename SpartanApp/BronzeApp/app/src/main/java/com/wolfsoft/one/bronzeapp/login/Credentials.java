package com.wolfsoft.one.bronzeapp.login;

import java.util.Date;

public class Credentials {
    private static String userName;
    private static String email;
    private static String password;
    private static Date birthday;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Credentials.userName = userName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Credentials.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Credentials.password = password;
    }

    public static Date getBirthday() {
        return birthday;
    }

    public static void setBirthday(Date birthday) {
        Credentials.birthday = birthday;
    }

    public static void logOut(){
        userName = null;
        email = null;
        password = null;
        birthday = null;
    }

    public static Boolean isLogedIn(){
        if (userName == null) return false;
        if (password == null) return false;
        if (email == null) return false;

        return (birthday != null);
    }
}
