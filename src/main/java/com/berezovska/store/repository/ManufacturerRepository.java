package com.berezovska.store.repository;

import com.berezovska.store.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, java.util.UUID> {
    Manufacturer findByName (String name);
}
