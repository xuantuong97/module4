package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p", Product.class);
        products = query.getResultList();
        return products;
    }
    @Transactional
    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }
    @Transactional
    @Override
    public void updateProduct(int id, Product product) {
        Product product1 = findById(id);
        if(product1 != null){
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setDescription(product.getDescription());
            product1.setManufacture(product.getManufacture());
            entityManager.merge(product1);
        }
    }
    @Transactional
    @Override
    public void deleteProduct(int id) {
        Product product = findById(id);
        if(product != null){
            entityManager.remove(product);
        }
    }

    @Override
    public Product findById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = new ArrayList<>();
        String sqlQuery = "select * from product where name like :name";
        Query query = entityManager.createNativeQuery(sqlQuery, Product.class);
        query.setParameter("name","%" + name +"%");
        products = query.getResultList();
        return products;
    }
}
