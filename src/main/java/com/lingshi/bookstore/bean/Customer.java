package com.lingshi.bookstore.bean;

public class Customer {
    private int userId;
    private String account;
    private String password;
    private double  balance;

    public Customer() {
    }

    public Customer(int userId, String account, String password, double balance) {
        this.userId = userId;
        this.account = account;
        this.password = password;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + userId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
