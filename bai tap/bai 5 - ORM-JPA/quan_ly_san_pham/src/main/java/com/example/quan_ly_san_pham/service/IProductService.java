package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void addProduct(Product product);
    void updateProduct(int id ,Product product);
    List<Product> search(String name);
    Product findById(int id);
    void deleteProduct(int id);
}
