package com.example.blogs.controller;

import com.example.blogs.model.Blog;
import com.example.blogs.model.BlogDto;
import com.example.blogs.model.Category;
import com.example.blogs.service.IBlogService;
import com.example.blogs.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> getAll(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "") String  keyword,
                                             @RequestParam(defaultValue = "0") int category){
        Pageable pageable = PageRequest.of(page,5, Sort.by("create_date").descending());
        Page<Blog> blogs = blogService.findAll(keyword,category,pageable);
        if(blogs.getContent().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody BlogDto blogDto){
        if(blogDto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = categoryService.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/{id_category}")
    public ResponseEntity<Page<Blog>> getBlogByCategory(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "") String  keyword,
                                             @PathVariable("id_category") int category) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("create_date").descending());
        Page<Blog> blogs = blogService.findAll(keyword, category, pageable);
        if (blogs.getContent().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id){
        try {
            Blog blog = blogService.findById(id);
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
