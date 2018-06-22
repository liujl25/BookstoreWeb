package com.lingshi.bookstore.bean;

import java.util.Date;

public class Cart {
    private int cartId;
    private Customer user;
    private Date createDate;


    public Cart() {
    }

    public Cart(int cartId, Customer user, Date createDate) {
        this.cartId = cartId;
        this.user = user;
        this.createDate = createDate;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", user=" + user +
                ", createDate=" + createDate +
                '}';
    }
}
