package com.river.web.function.smartrequst.model;

/**
 * @Author river66
 * @Date 2021/1/1 21:23
 */
public class User {
    private String userName;
    private String address;

    public User() {

    }

    public User(String userName, String address) {
        this.userName = userName;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
