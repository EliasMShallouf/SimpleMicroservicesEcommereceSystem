package com.example.ecomm.user.domain.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Table
@Entity
public class User implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.UUID) String id;
    @Column String name;
    @Column String email;
    @Column String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
