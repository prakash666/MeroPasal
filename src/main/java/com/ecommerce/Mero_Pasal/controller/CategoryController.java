package com.ecommerce.Mero_Pasal.controller;


import com.ecommerce.Mero_Pasal.model.Category;
import com.ecommerce.Mero_Pasal.service.CategoryService;
import com.ecommerce.Mero_Pasal.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<List<Category>> getAllCategories () {
       return new ResponseEntity<> (categoryService.getAllCategories (),HttpStatus.OK);

    }

    @PostMapping("/api/public/categories/post")
    public ResponseEntity<String> addCategory (@RequestBody Category category) {
        try {
            categoryService.postAllData (category);
            return new ResponseEntity<> ("Data has been posted", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<> (e.getReason (),e.getStatusCode ());
        }
    }


    @DeleteMapping("/api/admin/categories/{categoryId}")
  public ResponseEntity<String> deleteCategory (@PathVariable ("categoryId") Long Id) {
        try {
            String status = categoryService.deleteCategory (Id);
            return new ResponseEntity<> (status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<> (e.getReason (), e.getStatusCode ());
        }



  }



  @PatchMapping("/api/public/categories/{categoryId}")
  public ResponseEntity<String> updateCategory (@RequestBody Category category,  @PathVariable ("categoryId") Long id) {
        try {
            String status = categoryService.updateCategory (category);
            return new ResponseEntity<> (status,HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<> (e.getReason (), e.getStatusCode ());
        }
  }

}
