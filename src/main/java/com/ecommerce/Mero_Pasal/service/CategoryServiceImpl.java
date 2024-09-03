package com.ecommerce.Mero_Pasal.service;


import com.ecommerce.Mero_Pasal.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private Long nextId = 1L;
    private List<Category> categories = new ArrayList<> ();
    @Override
    public List<Category> getAllCategories () {
       return  categories;
    }

    @Override
    public String postAllData (Category category) {
        category.setCategoryId (nextId++); // this is used to generate an unique Id for category
        categories.add (category);
        return "Data has been posted";
    }

    @Override
    public String deleteCategory (Long Id) {
        categories.remove (Id);
        return "Data has been deleted";
    }
}
