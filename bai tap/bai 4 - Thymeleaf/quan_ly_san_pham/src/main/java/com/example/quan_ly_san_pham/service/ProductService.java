package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepo productRepo;
    @Override
    public List<Product> getAll() {
        return productRepo.getAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepo.addProduct(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        productRepo.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteProduct(id);
    }

    @Override
    public Product detail(int id) {
        return productRepo.detail(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepo.search(name);
    }
}
