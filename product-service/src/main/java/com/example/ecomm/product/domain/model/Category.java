package com.example.ecomm.product.domain.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Table
@Entity
public class Category implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.UUID) String id;
    @Column String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
