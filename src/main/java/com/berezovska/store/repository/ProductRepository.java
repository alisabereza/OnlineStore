package com.berezovska.store.repository;

import com.berezovska.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,java.util.UUID> {
    Product findByName (String name);
}
