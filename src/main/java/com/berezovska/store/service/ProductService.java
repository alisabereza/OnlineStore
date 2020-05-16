package com.berezovska.store.service;

import com.berezovska.store.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService extends BaseService<Product> {
    List<Product> getByName (String name);
    void delete(UUID id);
}
