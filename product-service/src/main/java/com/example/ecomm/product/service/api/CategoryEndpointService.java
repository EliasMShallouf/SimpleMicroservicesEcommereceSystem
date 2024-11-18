package com.example.ecomm.product.service.api;

import com.example.ecomm.product.domain.model.Category;
import com.example.ecomm.product.service.db.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryEndpointService {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Category category) {
        categoryService.save(category);
    }
}
