package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepo implements IProductRepo{
    private static Map<Integer, Product> productMap = new HashMap<>();
    static {
        productMap.put(1,new Product(1, "Iphone 13", 15000000,"New", "Apple"));
        productMap.put(2,new Product(2, "Iphone 12", 15000000,"New", "Apple"));
        productMap.put(3,new Product(3, "Iphone 11", 15000000,"New", "Apple"));
        productMap.put(4,new Product(4, "Iphone 14", 15000000,"New", "Apple"));
        productMap.put(5,new Product(5, "Iphone 15", 15000000,"New", "Apple"));
    }
    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        productMap.remove(id);
    }

    @Override
    public Product detail(int id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        for(Map.Entry<Integer, Product> entry : productMap.entrySet()){
            if(entry.getValue().getName().contains(name)){
                productList.add(entry.getValue());
            }
        }
        return productList;
    }
}
