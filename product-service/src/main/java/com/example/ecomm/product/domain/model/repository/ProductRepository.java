package com.example.ecomm.product.domain.model.repository;

import com.example.ecomm.product.domain.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}
