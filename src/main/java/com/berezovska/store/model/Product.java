package com.berezovska.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;


@NoArgsConstructor
@Entity
@Table (name = "products")
public @Data class Product extends BaseEntity {
    @Column (name = "name")
    private String name;
    @Column (name = "price")
    private Double price;

    @ManyToOne (cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return manufacturer.equals(product.manufacturer) &&
                name.equals(product.name) &&
                price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, name, price);
    }

    @Override
    public UUID getId() {
        return super.getId();
    }
    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder(("Product{"));
        sb.append(super.toString());
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append("}");
        return sb.toString();
    }
}
