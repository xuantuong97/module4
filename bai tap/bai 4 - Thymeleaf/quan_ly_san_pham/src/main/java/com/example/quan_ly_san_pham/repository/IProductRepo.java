package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getAll();
    void addProduct(Product product);
    void updateProduct(int id ,Product product);
    void deleteProduct(int id);
    Product detail(int id);
    List<Product> search(String name);
}
