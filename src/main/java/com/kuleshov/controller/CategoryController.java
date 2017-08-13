package com.kuleshov.controller;

import com.kuleshov.annotation.RequestMapping;
import com.kuleshov.service.CategoryService;
import com.kuleshov.web.Controller;
import com.kuleshov.web.HttpMethod;
import com.kuleshov.web.ModelAndView;
import com.kuleshov.web.View;

public class CategoryController implements Controller {

    private CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(url = "/category/find", method = HttpMethod.GET)
    public ModelAndView findCategoryById(String name) {
        ModelAndView view = new ModelAndView(View.CATEGORY);
//        Category category = CategoryService.findCategoryByName(name);
//        view.addParameter("category", category);
        return view;
    }
}
