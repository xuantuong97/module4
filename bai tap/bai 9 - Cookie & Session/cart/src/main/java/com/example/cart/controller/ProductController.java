package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Product product = productService.getProduct(id);
        if (action.equals("show")) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product);
        return "redirect:/shop";
    }

    @GetMapping("/sub/{id}")
    public String subToCart(@PathVariable int id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Product product = productService.getProduct(id);
        if (action.equals("show")) {
            cart.subProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.subProduct(product);
        return "redirect:/shop";
    }
}
