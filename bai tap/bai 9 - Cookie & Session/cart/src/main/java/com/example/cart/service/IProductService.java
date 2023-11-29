package com.example.cart.service;

import com.example.cart.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product getProduct(int id);
}
