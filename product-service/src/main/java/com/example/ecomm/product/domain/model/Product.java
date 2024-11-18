package com.example.ecomm.product.domain.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Table
@Entity
public class Product implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.UUID) String id;
    @Column String name;
    @OneToOne @JoinColumn(name = "category_id") Category category;

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

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
