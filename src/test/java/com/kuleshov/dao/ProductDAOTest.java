package com.kuleshov.dao;

import com.kuleshov.entity.Category;
import com.kuleshov.entity.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductDAOTest {

    private CategoryDAO categoryDAO = new CategoryDAO();
    private Category category = new Category();

    private ProductDAO productDAO = new ProductDAO();
    private Product inputValue = new Product();
    private Product updateValue = new Product();

    @Test
    public void shouldSaveProduct() {

        //given
        category.setCategoryId(1);
        category.setCategoryName("Tech");
        category.setCategoryDescription("Tech description");

        inputValue.setProductId("id123");
        inputValue.setProductName("name");
        inputValue.setQuantityInStock(999);
        inputValue.setPrice(499);
        inputValue.setDescription("desc prod");
        inputValue.setBrand("brand");
        inputValue.setCategoryCategoryId(1);

        //when
        boolean saveCategory = categoryDAO.save(category);
        boolean save = productDAO.save(inputValue);
        Product find = productDAO.findId("id123");
        boolean delete = productDAO.delete("id123");
        boolean deleteCategory = categoryDAO.delete("Tech");

        //then
        Assert.assertTrue(saveCategory);
        Assert.assertTrue(save);
        Assert.assertEquals(find,inputValue);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteCategory);
    }

    @Test
    public void shouldFindProduct() {

        //given
        category.setCategoryId(2);
        category.setCategoryName("Tech");
        category.setCategoryDescription("Tech description");

        inputValue.setProductId("id123");
        inputValue.setProductName("name");
        inputValue.setQuantityInStock(999);
        inputValue.setPrice(499);
        inputValue.setDescription("desc prod");
        inputValue.setBrand("brand");
        inputValue.setCategoryCategoryId(2);

        //when
        boolean saveCategory = categoryDAO.save(category);
        boolean save = productDAO.save(inputValue);
        Product find = productDAO.findId("id123");
        boolean delete = productDAO.delete("id123");
        boolean deleteCategory = categoryDAO.delete("Tech");

        //then
        Assert.assertTrue(saveCategory);
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteCategory);
    }

    @Test
    public void shouldUpdateProduct() {

        //given
        category.setCategoryId(4);
        category.setCategoryName("Tech");
        category.setCategoryDescription("Tech description");

        inputValue.setProductId("id123");
        inputValue.setProductName("name");
        inputValue.setQuantityInStock(999);
        inputValue.setPrice(499);
        inputValue.setDescription("desc prod");
        inputValue.setBrand("brand");
        inputValue.setCategoryCategoryId(4);

        updateValue.setProductId("id123");
        updateValue.setProductName("newName");
        updateValue.setQuantityInStock(1000);
        updateValue.setPrice(399);
        updateValue.setDescription("new desc prod");
        updateValue.setBrand("newBrand");
        updateValue.setCategoryCategoryId(4);

        //when
        boolean saveCategory = categoryDAO.save(category);
        boolean save = productDAO.save(inputValue);
        boolean update = productDAO.update(updateValue);
        Product find = productDAO.findId("id123");
        boolean delete = productDAO.delete("id123");
        boolean deleteCategory = categoryDAO.delete("Tech");

        //then
        Assert.assertTrue(saveCategory);
        Assert.assertTrue(save);
        Assert.assertTrue(update);
        Assert.assertEquals(updateValue, find);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteCategory);
    }

    @Test
    public void shouldDeleteProduct() {

        //given
        category.setCategoryId(3);
        category.setCategoryName("NewTech");
        category.setCategoryDescription("Tech description");

        inputValue.setProductId("id123");
        inputValue.setProductName("name");
        inputValue.setQuantityInStock(999);
        inputValue.setPrice(499);
        inputValue.setDescription("desc prod");
        inputValue.setBrand("brand");
        inputValue.setCategoryCategoryId(3);

        //when
        boolean saveCategory = categoryDAO.save(category);
        boolean save = productDAO.save(inputValue);
        boolean delete = productDAO.delete("id123");
        Product findAfterDelete = productDAO.findId("id123");
        boolean deleteCategory = categoryDAO.delete("NewTech");

        //then
        Assert.assertTrue(saveCategory);
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteCategory);
        Assert.assertNotEquals(inputValue, findAfterDelete);
    }
}