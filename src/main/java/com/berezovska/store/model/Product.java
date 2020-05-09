package com.berezovska.store.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table (name = "products")
public @Data class Product extends BaseEntity {
    @Column (name = "name")
    private String name;
    @Column (name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
}
