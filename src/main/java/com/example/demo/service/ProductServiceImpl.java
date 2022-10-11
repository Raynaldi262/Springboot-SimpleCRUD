package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.utils.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public Iterable<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public void addProduct(Product product) {
        repo.save(product);
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Product> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public void editProduct(Product product) {
        repo.save(product);
    }

    @Override
    public List<Product> findByName(String keyword) {
        return repo.findByNameContains(keyword);
    }


}
