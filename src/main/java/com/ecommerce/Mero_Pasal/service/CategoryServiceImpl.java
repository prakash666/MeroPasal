package com.ecommerce.Mero_Pasal.service;


import com.ecommerce.Mero_Pasal.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Category category = categories.stream ()
                .filter (n->n.getCategoryId ().equals (Id))
                .findFirst ()
                .orElseThrow (()-> new ResponseStatusException (HttpStatus.NOT_FOUND, "Id does not match"));
        categories.remove (category);
        return "Id has been found and deleted";
    }

    @Override
    public String updateCategory (Category category ) {
        Optional<Category> updateCategory = categories.stream ()
                .filter (n->n.getCategoryId ().equals (category.getCategoryId ()))
                .findFirst ();

        if (updateCategory.isPresent ()) {
            Category existingCategory = updateCategory.get ();
            if (existingCategory.getCategoryName () != null) {
                existingCategory.setCategoryName (category.getCategoryName ());
                categories.add (existingCategory);
            }
        } else {
            throw new ResponseStatusException (HttpStatus.NOT_FOUND, "Id not found");
        }

        return "Category has been updated";


    }
}
