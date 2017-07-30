package com.kuleshov.dao;

import com.kuleshov.entity.Category;
import com.kuleshov.util.JDBCFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class CategoryDAOTest extends TestCase {

    CategoryDAO categoryDAO = new CategoryDAO();
    Category inputValue = new Category();

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

    public void testFindName() throws Exception {
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

    public void testFindId() throws Exception {
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
}