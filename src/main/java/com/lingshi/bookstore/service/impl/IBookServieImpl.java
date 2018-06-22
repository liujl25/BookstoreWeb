package com.lingshi.bookstore.service.impl;

import com.lingshi.bookstore.bean.Book;
import com.lingshi.bookstore.bean.Pager;
import com.lingshi.bookstore.dao.BookMapper;
import com.lingshi.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IBookServieImpl implements IBookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAll() {
            return this.bookMapper.findAll();
    }

    @Override
    public Book findBookById(String isbn) {
        return this.bookMapper.findBookById(isbn);
    }

    @Override
    public List<Book> findBookByExample(Book book) {
        return this.bookMapper.findBookByExample(book);
    }

    @Override
    public boolean addBook(Book book) {
      return this.bookMapper.addBook(book)>0?true:false;
    }

    @Override
    public boolean editBook(Book book) {
       return this.bookMapper.editBook(book)>0?true:false;
    }

    @Override
    public boolean deleteBookById(String isbn) {
        return this.bookMapper.deleteBookById(isbn)>0?true:false;
    }

    @Override
    public List<Book> findByPager(Pager pager) {
        return this.bookMapper.findByPager(pager);
    }

    @Override
    public int countForPager(Pager pager) {
        return this.bookMapper.countForPager(pager);
    }
}
