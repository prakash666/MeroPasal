package com.ecommerce.Mero_Pasal.controller;


import com.ecommerce.Mero_Pasal.model.Category;
import com.ecommerce.Mero_Pasal.service.CategoryService;
import com.ecommerce.Mero_Pasal.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private final CategoryServiceImpl categoryService;


    @Autowired
    public CategoryController (CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }


    private List<Category> categories = new ArrayList<> ();

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories () {
        return  categoryService.getAllCategories ();
    }

    @PostMapping("/api/public/categories/post")
    public ResponseEntity<String> addCategory (@RequestBody Category category) {
       categoryService.postAllData (category);
        return new ResponseEntity<> ("Data has been posted", HttpStatus.OK);
    }


    @DeleteMapping("/api/admin/categories/{categoryId}")
  public ResponseEntity<String> deleteCategory ( @PathVariable ("categoryId") Long Id) {
        String status = categoryService.deleteCategory (Id);
        return new ResponseEntity<> ("Data has been delete", HttpStatus.OK);
  }


}
