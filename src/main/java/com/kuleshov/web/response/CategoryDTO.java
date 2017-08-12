package com.kuleshov.web.response;

import com.kuleshov.entity.Category;

import java.io.Serializable;

public class CategoryDTO implements Serializable {

    private int categoryId;
    private String categoryName;
    private String categoryDescription;


    public CategoryDTO(Category category) {
        categoryId = category.getCategoryId();
        categoryName = category.getCategoryName();
        categoryDescription = category.getCategoryDescription();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
