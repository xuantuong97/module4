package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;
    @RequestMapping("/")
    public String showHome(Model model){
        List<Product> productList = productService.getAll();
        model.addAttribute("productList",productList);
        return "/index";
    }
    @GetMapping("/create")
    public String showAddForm(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/create/save")
    public String addNew(@ModelAttribute("product") Product product, Model model){
        productService.addProduct(product);
        model.addAttribute("productList", productService.getAll());
        return "/index";
    }
    @GetMapping("/product/detail/{id}")
    public String showDetail(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/detail";
    }
    @GetMapping("/product/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/edit";
    }
    @PostMapping("/product/edit/save")
    public String editProduct(@ModelAttribute("product") Product product, Model model){
        productService.updateProduct(product.getId(), product);
        model.addAttribute("productList", productService.getAll());
        return "/index";
    }
    @GetMapping("/product/delete")
    public String deleteProduct(@RequestParam int id, Model model){
        productService.deleteProduct(id);
        model.addAttribute("productList", productService.getAll());
        return "/index";
    }
    @GetMapping("/product/search")
    public String search(@RequestParam("keyword") String keyword, Model model){
        model.addAttribute("productList", productService.search(keyword));
        model.addAttribute("keyword",keyword);
        return "/search";
    }
}
