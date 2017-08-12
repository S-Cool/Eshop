package com.kuleshov.service;

import com.kuleshov.dao.CategoryDAO;
import com.kuleshov.entity.Category;
import com.kuleshov.web.response.CategoryDTO;

public class CategoryService {

    private CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public Category findCategoryByName(String name) {
        return categoryDAO.find(name);
    }

    public CategoryDTO saveCategory(int id, String name, String desc) {
        Category dto = new Category();
        dto.setCategoryId(id);
        dto.setCategoryName(name);
        dto.setCategoryName(desc);

        categoryDAO.save(dto);

        Category category = categoryDAO.find(name);
        return new CategoryDTO(category);
    }
}
