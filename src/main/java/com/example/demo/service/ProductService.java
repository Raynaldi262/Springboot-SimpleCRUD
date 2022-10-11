package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Iterable<Product> findAll();
    public void addProduct(Product product);
    public void deleteById(long id);
    public Optional<Product> findById(long id);
    public void editProduct(Product product);
    public List<Product> findByName(String keyword);
}
