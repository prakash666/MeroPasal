package com.ecommerce.Mero_Pasal.service;

import com.ecommerce.Mero_Pasal.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    String postAllData(Category category);
    String deleteCategory (Long Id);

}
