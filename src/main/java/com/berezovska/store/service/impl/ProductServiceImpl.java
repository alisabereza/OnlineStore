package com.berezovska.store.service.impl;

import com.berezovska.store.controller.exception.ProductAlreadyExistsException;
import com.berezovska.store.controller.exception.ProductNotExistsException;
import com.berezovska.store.model.Product;
import com.berezovska.store.repository.ProductRepository;
import com.berezovska.store.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LogManager.getLogger(ProductServiceImpl.class);

    private ProductRepository productRepository;

    @Autowired
    public void setRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getByName(String name) {
        LOG.debug("get Products by name: ");
        return productRepository.findAll().stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getAll() {
        LOG.debug("All Products: ");
        return productRepository.findAll();
    }

    @Override
    public Product getById(UUID id) {
        LOG.debug("get Product by ID: ");
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotExistsException(String.format("Product with id = %s not found", id)));
    }

    @Override
    public void save(Product entity) {
        LOG.debug("Save Product: ");

        if (getByName(entity.getName()).stream().filter(p -> p.getManufacturer().equals(entity.getManufacturer())).findAny().isPresent()) {
            throw new ProductAlreadyExistsException("Product already exists: " + entity.getName());
        }
        productRepository.save(entity);
    }

    @Override
    public void delete(@Param("id") UUID id) {
        LOG.debug("Deleting Product: " + id);
        try {
            productRepository.deleteById(id);
        } catch (ProductNotExistsException e) {
            LOG.debug(e.getMessage());
        }
    }

    @Override
    public Product update(Product entity) {
        LOG.debug("Updating Product: ");
        return productRepository.save(entity);
    }
}
