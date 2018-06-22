package com.lingshi.bookstore.service.impl;

import com.lingshi.bookstore.bean.Category;
import com.lingshi.bookstore.dao.CategoryMapper;
import com.lingshi.bookstore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ICategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        return this.categoryMapper.findAll();
    }

    @Override
    public List<Category> findAllWithBook() {
        return this.categoryMapper.findAllWithBook();
    }

    @Override
    public List<Category> searchByName(Category category) {
        return this.categoryMapper.searchByName(category);
    }

    @Override
    public boolean addCategory(Category category) {
        return this.categoryMapper.addCategory(category)>0?true:false;
    }

    @Override
    public boolean editCategory(Category category) {
        return this.categoryMapper.editCategory(category)>0?true:false;
    }

    @Override
    public boolean deleteById(int id) {
        return this.categoryMapper.deleteById(id)>0?true:false;
    }
}
