package com.berezovska.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
public abstract @Data class BaseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private java.util.UUID id;

   @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder(("BaseEntity{"));
        sb.append("id=").append(id);
        sb.append("}");
        return sb.toString();
    }
}
