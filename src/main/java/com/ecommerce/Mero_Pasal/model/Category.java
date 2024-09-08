package com.ecommerce.Mero_Pasal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Category {
    @Id
    private Long categoryId /* = Long.valueOf ( UUID.randomUUID ().toString ())*/;
    private String categoryName;

    public Long getCategoryId () {
        return categoryId;
    }

    public void setCategoryId (Long categoryId) {
        this.categoryId = categoryId;
    }


    public String getCategoryName () {
        return categoryName;
    }

    public void setCategoryName (String categoryName) {
        this.categoryName  = categoryName;
    }

    public Category (Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
    public Category () {

    }
}
