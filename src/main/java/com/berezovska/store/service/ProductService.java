package com.berezovska.store.service;

import com.berezovska.store.model.Product;

public interface ProductService extends BaseService<Product> {
    Product getByName (String name);
}
