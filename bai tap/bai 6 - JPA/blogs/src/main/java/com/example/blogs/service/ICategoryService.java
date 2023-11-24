package com.example.blogs.service;

import com.example.blogs.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    void save(Category category);
}
