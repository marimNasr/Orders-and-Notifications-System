package com.example.Order_Management_SWE2.Customer.model;

public class Customer {
    private String userName;
    private String email;
    private String pass;
    private String phoneNum;
    private String address;
    private float balance;
    private String language;


    private String notificationType;

    public Customer(String userName, String email, String pass, String phoneNum, String address,
                    float balance, String language, String notificationType){
        this.userName = userName;
        this.email = email;
        this.pass = pass;
        this.phoneNum = phoneNum;
        this.address = address;
        this.balance = balance;
        this.language = language;
        this.notificationType = notificationType;
    }

    public Customer(){};

    public String getLanguage() {
        return language;
    }
    public String getNotificationType() {
        return notificationType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
