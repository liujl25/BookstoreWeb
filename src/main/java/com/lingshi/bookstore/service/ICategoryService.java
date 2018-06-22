package com.lingshi.bookstore.service;

import com.lingshi.bookstore.bean.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> findAll();
    public List<Category> findAllWithBook();
    public List<Category> searchByName(Category category);

    public boolean addCategory(Category category);
    public boolean editCategory(Category category);
    public boolean deleteById(int id);
}
