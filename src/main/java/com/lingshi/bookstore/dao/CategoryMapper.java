package com.lingshi.bookstore.dao;

import com.lingshi.bookstore.bean.Category;

import java.util.List;

/**
 * @description
 * @auther 暴走D红领巾
 * @date 2018/6/16 23:36
 */
public interface CategoryMapper {

    public List<Category> findAll();
    public List<Category> findAllWithBook();
    public List<Category> searchByName(Category category);

    public int addCategory(Category category);
    public int editCategory(Category category);
    public int deleteById(int id);




}
