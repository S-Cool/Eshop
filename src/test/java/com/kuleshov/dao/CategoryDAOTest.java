package com.kuleshov.dao;

import com.kuleshov.entity.Category;
import org.junit.Assert;
import org.junit.Test;

public class CategoryDAOTest {

    private CategoryDAO categoryDAO = new CategoryDAO();
    private Category inputValue = new Category();
    private Category updateValue = new Category();

    @Test
    public void shouldSaveCategory() {

        //given
        inputValue.setCategoryId(1);
        inputValue.setCategoryName("Tech");
        inputValue.setCategoryDescription("Tech description");

        //when
        boolean save = categoryDAO.save(inputValue);
        Category find = categoryDAO.find("Tech");
        boolean delete = categoryDAO.delete("Tech");

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(find,inputValue);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldFindCategoryById() {

        //given
        inputValue.setCategoryId(3);
        inputValue.setCategoryName("Microwave");
        inputValue.setCategoryDescription("Microwave description");

        //when
        boolean save = categoryDAO.save(inputValue);
        Category find = categoryDAO.find("Microwave");
        boolean delete = categoryDAO.delete("Microwave");

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldFindCategoryByName() {

        //given
        inputValue.setCategoryId(4);
        inputValue.setCategoryName("Kettle");
        inputValue.setCategoryDescription("Kettle description");

        //when
        boolean save = categoryDAO.save(inputValue);
        Category find = categoryDAO.find(4);
        boolean delete = categoryDAO.delete("Kettle");

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldUpdateCategory() {

        //given
        inputValue.setCategoryId(1);
        inputValue.setCategoryName("Tech");
        inputValue.setCategoryDescription("Tech description");

        updateValue.setCategoryId(1);
        updateValue.setCategoryName("New");
        updateValue.setCategoryDescription("New description");

        //when
        boolean save = categoryDAO.save(inputValue);
        boolean update = categoryDAO.update(updateValue);
        Category find = categoryDAO.find("New");
        boolean delete = categoryDAO.delete("New");

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(update);
        Assert.assertEquals(updateValue, find);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldDeleteCategory() {

        //given
        inputValue.setCategoryId(2);
        inputValue.setCategoryName("Refrigerator");
        inputValue.setCategoryDescription("Refrigerator description");

        //when
        boolean save = categoryDAO.save(inputValue);
        boolean delete = categoryDAO.delete("Refrigerator");
        Category findAfterDelete = categoryDAO.find("Refrigerator");

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
        Assert.assertNotEquals(inputValue, findAfterDelete);
    }
}