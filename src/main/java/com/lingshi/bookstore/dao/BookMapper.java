package com.lingshi.bookstore.dao;

import com.lingshi.bookstore.bean.Book;
import com.lingshi.bookstore.bean.Pager;

import java.util.List;

public interface BookMapper {
    //查找全部
    public List<Book> findAll();

    public Book findBookById(String isbn);

    public List<Book> findBookByExample(Book book);

    public int addBook(Book book);

    public int editBook(Book book);

    public int deleteBookById(String isbn);

    /**
     * 分页查询
     * @param pager
     * @return
     */
    public List<Book> findByPager(Pager pager);

    /**
     * 与分页查询sql条件一致的统计查询
     * @param pager
     * @return
     */
    public int countForPager(Pager pager);



}
