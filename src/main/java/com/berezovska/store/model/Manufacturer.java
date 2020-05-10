package com.berezovska.store.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table (name = "manufacturers")
public @Data class Manufacturer extends BaseEntity {
    @Column (name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "manufacturer")
    private Set<Product> products;

}
