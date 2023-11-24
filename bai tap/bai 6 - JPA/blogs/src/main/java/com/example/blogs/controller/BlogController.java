package com.example.blogs.controller;


import com.example.blogs.model.Blog;
import com.example.blogs.model.Category;
import com.example.blogs.service.IBlogService;
import com.example.blogs.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public String showList(Model model,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String  keyword,
                           @RequestParam(defaultValue = "0") int category){
        Pageable pageable = PageRequest.of(page,1, Sort.by("create_date").ascending());
        Page<Blog> blogs = blogService.findAll(keyword,category,pageable);
        model.addAttribute("selectedCategory", category);
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("blogs",blogs);
        model.addAttribute("keyword", keyword);
    return "/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        Blog blog = new Blog();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("blog", blog);
        return "/create";
    }
    @PostMapping("/create")
    public String addNew( Blog blog){
        blog.setCreateDate(LocalDateTime.now());
        blogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        blogService.delete(id);
        return "redirect:/blog";
    }
    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update(Blog blog){
        blogService.update(blog);
        return "redirect:/blog";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "/detail";
    }
    @GetMapping("/category")
    public String showCategoryList(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "/category_list";
    }
    @GetMapping("/create_category")
    public String showFormCreateCategory(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "/create_category";
    }
    @PostMapping("/create_category")
    public String addNewCategory(Category category, Model model){
        categoryService.save(category);
        model.addAttribute("categories", categoryService.findAll());
        return "redirect:/blog/category";
    }
    @GetMapping("/update_category/{id}")
    public String showUpdateCategory(@PathVariable int id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "/update_category";
    }
    @PostMapping("/update_category")
    public String updateCategory(Category category){
        categoryService.save(category);
        return "redirect:/blog/category";
    }
}
