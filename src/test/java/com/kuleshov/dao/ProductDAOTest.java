package com.kuleshov.dao;

import com.kuleshov.entity.Category;
import com.kuleshov.entity.Product;
import junit.framework.TestCase;
import org.junit.Assert;

public class ProductDAOTest extends TestCase {

    CategoryDAO categoryDAO = new CategoryDAO();
    Category category = new Category();

    ProductDAO productDAO = new ProductDAO();
    Product inputValue = new Product();
    Product updateValue = new Product();

    public void testSave() throws Exception {
        //given
        category.setCategoryId(1);
        category.setCategoryName("Tech");
        category.setCategoryDescription("Tech description");

        inputValue.setProductId(1);
        inputValue.setProductName("name");
        inputValue.setQuantityInStock(999);
        inputValue.setPrice(499);
        inputValue.setDescription("desc prod");
        inputValue.setBrand("brand");
        inputValue.setCategoryCategoryId(1);

        //when
        boolean saveCategory = categoryDAO.save(category);
        boolean save = productDAO.save(inputValue);
        boolean delete = productDAO.delete(1);
        boolean deleteCategory = categoryDAO.delete("Tech");

        //then
        Assert.assertTrue(saveCategory);
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteCategory);
    }

    public void testFindId() throws Exception {
        //given
        category.setCategoryId(2);
        category.setCategoryName("Tech");
        category.setCategoryDescription("Tech description");

        inputValue.setProductId(2);
        inputValue.setProductName("name");
        inputValue.setQuantityInStock(999);
        inputValue.setPrice(499);
        inputValue.setDescription("desc prod");
        inputValue.setBrand("brand");
        inputValue.setCategoryCategoryId(2);

        //when
        boolean saveCategory = categoryDAO.save(category);
        boolean save = productDAO.save(inputValue);
        Product find = productDAO.findId(2);
        boolean delete = productDAO.delete(2);
        boolean deleteCategory = categoryDAO.delete("Tech");

        //then
        Assert.assertTrue(saveCategory);
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteCategory);
    }

    public void testUpdate() throws Exception {
        //given
        category.setCategoryId(4);
        category.setCategoryName("Tech");
        category.setCategoryDescription("Tech description");

        inputValue.setProductId(4);
        inputValue.setProductName("name");
        inputValue.setQuantityInStock(999);
        inputValue.setPrice(499);
        inputValue.setDescription("desc prod");
        inputValue.setBrand("brand");
        inputValue.setCategoryCategoryId(4);

        inputValue.setProductId(4);
        inputValue.setProductName("newName");
        inputValue.setQuantityInStock(1000);
        inputValue.setPrice(399);
        inputValue.setDescription("new desc prod");
        inputValue.setBrand("newBrand");
        inputValue.setCategoryCategoryId(4);

        //when
        boolean saveCategory = categoryDAO.save(category);
        boolean save = productDAO.save(inputValue);
        boolean update = productDAO.update(updateValue);
        boolean delete = productDAO.delete(4);
        boolean deleteCategory = categoryDAO.delete("Tech");

        //then
        Assert.assertTrue(saveCategory);
        Assert.assertTrue(save);
        Assert.assertTrue(update);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteCategory);
    }

    public void testDelete() throws Exception {
        //given
        category.setCategoryId(3);
        category.setCategoryName("NewTech");
        category.setCategoryDescription("Tech description");

        inputValue.setProductId(3);
        inputValue.setProductName("name");
        inputValue.setQuantityInStock(999);
        inputValue.setPrice(499);
        inputValue.setDescription("desc prod");
        inputValue.setBrand("brand");
        inputValue.setCategoryCategoryId(3);

        //when
        boolean saveCategory = categoryDAO.save(category);
        boolean save = productDAO.save(inputValue);
        boolean delete = productDAO.delete(3);
        boolean deleteCategory = categoryDAO.delete("NewTech");

        //then
        Assert.assertTrue(saveCategory);
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteCategory);
    }
}