package com.lingshi.bookstore.bean;

import java.util.Date;

public class Cart_item {
    private int cartItemId;
    private Cart cart;
    private Book book;
    private int count;
    private Date addTime;

    public Cart_item() {
    }

    public Cart_item(int cartItemId, Cart cart, Book book, int count, Date addTime) {
        this.cartItemId = cartItemId;
        this.cart = cart;
        this.book = book;
        this.count = count;
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "Cart_item{" +
                "cartItemId=" + cartItemId +
                ", cart=" + cart +
                ", book=" + book +
                ", count=" + count +
                ", addTime=" + addTime +
                '}';
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
