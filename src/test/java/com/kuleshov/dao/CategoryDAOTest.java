package com.kuleshov.dao;

import com.kuleshov.entity.Category;
import junit.framework.TestCase;
import org.junit.Assert;

public class CategoryDAOTest extends TestCase {

    CategoryDAO categoryDAO = new CategoryDAO();
    Category inputValue = new Category();
    Category updateValue = new Category();

    public void testSave() throws Exception {
        //given
        inputValue.setCategoryId(1);
        inputValue.setCategoryName("Tech");
        inputValue.setCategoryDescription("Tech description");

        //when
        boolean save = categoryDAO.save(inputValue);
        boolean delete = categoryDAO.delete("Tech");

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
    }

    public void testFindName() throws Exception {
        //given
        inputValue.setCategoryId(3);
        inputValue.setCategoryName("Microwave");
        inputValue.setCategoryDescription("Microwave description");

        //when
        boolean save = categoryDAO.save(inputValue);
        Category find = categoryDAO.findName("Microwave");
        boolean delete = categoryDAO.delete("Microwave");

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
    }

    public void testFindId() throws Exception {
        //given
        inputValue.setCategoryId(4);
        inputValue.setCategoryName("Kettle");
        inputValue.setCategoryDescription("Kettle description");

        //when
        boolean save = categoryDAO.save(inputValue);
        Category find = categoryDAO.findId(4);
        boolean delete = categoryDAO.delete("Kettle");

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
    }

    public void testUpdate() throws Exception {
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
        boolean delete = categoryDAO.delete("New");

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(update);
        Assert.assertTrue(delete);
    }

    public void testDeleteName() throws Exception {
        //given
        inputValue.setCategoryId(2);
        inputValue.setCategoryName("Refrigerator");
        inputValue.setCategoryDescription("Refrigerator description");

        //when
        boolean save = categoryDAO.save(inputValue);
        boolean delete = categoryDAO.delete("Refrigerator");

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
    }
}