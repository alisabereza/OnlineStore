package com.berezovska.store.service.impl;

import com.berezovska.store.model.Product;
import com.berezovska.store.repository.ProductRepository;
import com.berezovska.store.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LogManager.getLogger(ProductServiceImpl.class);

    private ProductRepository productRepository;
    @Autowired
    public void setRepository (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getByName(String name) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getById(UUID id) {
        return null;
    }

    @Override
    public void save(Product entity) {

    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public Product update(Product entity) {
        return null;
    }
}
