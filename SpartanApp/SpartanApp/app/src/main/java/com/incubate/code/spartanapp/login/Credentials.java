package com.incubate.code.spartanapp.login;

import java.util.Date;

/**
 * Credentials Model Object.
 * Various attributes of Credentials and related behavior.
 * Credentials class implement all the attribute needed for a student.
 * These include userID, userName,email,password,birthday.
 *
 * @author Philp H
 * @author Abraham T
 * @version 1.0
 *
 */
public class Credentials {
    private static String userID;
    private static String userName;
    private static String email;
    private static String password;
    private static Date birthday;

    /**
     * Get user name.
     * @return
     */
    public static String getUserName() {
        return userName;
    }

    /**
     *Set User Name
     * @param userName
     */
    public static void setUserName(String userName) {
        Credentials.userName = userName;
    }

    /**
     *
     * @return
     */
    public static String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public static void setEmail(String email) {
        Credentials.email = email;
    }

    /**
     *
     * @return
     */
    public static String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public static void setPassword(String password) {
        Credentials.password = password;
    }

    /**
     *
     * @return
     */
    public static Date getBirthday() {
        return birthday;
    }

    /**
     *
     * @param birthday
     */
    public static void setBirthday(Date birthday) {
        Credentials.birthday = birthday;
    }

    /**
     *
     */
    public static void logOut(){
        userName = null;
        email = null;
        password = null;
        birthday = null;
        userID = null;
    }

    /**
     *
     * @return
     */
    public static Boolean isLogedIn(){
        if (userID == null) return false;
        if (userName == null) return false;
        if (password == null) return false;
        if (email == null) return false;

        return (birthday != null);
    }

    /**
     *
     * @return
     */
    public static String getUserID() {
        return userID;
    }

    /**
     *
     * @param userID
     */
    public static void setUserID(String userID) {
        Credentials.userID = userID;
    }
}
