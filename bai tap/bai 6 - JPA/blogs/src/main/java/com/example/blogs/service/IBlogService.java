package com.example.blogs.service;

import com.example.blogs.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService {
    Page<Blog> findAll(String name,int categoryId, Pageable pageable);
    void save(Blog blog);
    void delete(int id);
    void update(Blog blog);
    Blog findById(int id);
}
