package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void addProduct(Product product);
    void updateProduct(int id ,Product product);
    void deleteProduct(int id);
    Product detail(int id);
    List<Product> search(String name);
}
