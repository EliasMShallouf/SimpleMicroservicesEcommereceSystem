package com.example.ecomm.product.domain.model.repository;

import com.example.ecomm.product.domain.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> {
}
