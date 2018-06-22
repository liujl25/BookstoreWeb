package com.lingshi.bookstore.bean;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * eeeeeee???????
 */
public class Book {
    private String isbn;
//    @NotBlank(message="{bookName.not.null}")
    @Size(min=1,max=50,message="{bookNameRange}")
    private String bookName;
    private Double price;
    private Date publishDate;
    private String publisher;
    //外键
    private Category category;

    private String bookImage;

    public Book() {
    }
    public Book(String isbn, String bookName, Double price, Date publishDate, String publisher, Category category) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.price = price;
        this.publishDate = publishDate;
        this.publisher = publisher;
        this.category = category;
    }

    public Book(String isbn, String bookName, Double price, Date publishDate, String publisher, Category category, String bookImage) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.price = price;
        this.publishDate = publishDate;
        this.publisher = publisher;
        this.category = category;
        this.bookImage = bookImage;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", publisher='" + publisher + '\'' +
                ", category=" + category +
                '}';
    }
}
