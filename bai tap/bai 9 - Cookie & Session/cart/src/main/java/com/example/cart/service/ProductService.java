package com.example.cart.service;

import com.example.cart.model.Product;
import com.example.cart.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(int id) {
        return productRepo.findById(id).get();
    }
}
