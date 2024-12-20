package com.example.ecomm.product.service.db;

import com.example.ecomm.product.domain.model.Category;
import com.example.ecomm.product.domain.model.repository.CategoryRepository;
import com.example.ecomm.product.service.utils.ListHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAll() {
        return ListHelper.toList(categoryRepository.findAll());
    }
}
