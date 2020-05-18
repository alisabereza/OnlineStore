package com.berezovska.store.service;

import com.berezovska.store.model.Product;

import java.util.List;

public interface ProductService extends BaseService<Product> {
    List<Product> getByName (String name);
}
