package com.example.blogs.service;

import com.example.blogs.model.Blog;
import com.example.blogs.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo blogRepo;
    @Override
    public Page<Blog> findAll(String name,int categoryId, Pageable pageable) {
        return blogRepo.findAll("%" + name + "%",categoryId, pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepo.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        Blog blog1 = blogRepo.findById(blog.getId()).get();
        blog.setCreateDate(blog1.getCreateDate());
        blogRepo.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepo.findById(id).get();
    }
}
