package com.kuleshov.dao;

import com.kuleshov.entity.Category;
import com.kuleshov.util.JDBCFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

public class CategoryDAOTest extends TestCase {

    @Before
    public void runT() {
        JDBCFactory jdbcFactory = new JDBCFactory();
        jdbcFactory.getConnection();

    }

    public void testSave() throws Exception {
        CategoryDAO categoryDAO = new CategoryDAO();
        Category inputValue = new Category();

        inputValue.setCategoryId(1);
        inputValue.setCategoryName("Tech");
        inputValue.setCategoryDescription("Tech description");

        categoryDAO.save(inputValue);

        Category expectedOne = categoryDAO.find(1);
        Category expectedTwo = categoryDAO.find("Tech");

        Assert.assertEquals(inputValue, expectedOne);
        Assert.assertEquals(inputValue, expectedTwo);

        categoryDAO.delete("Tech");

        assertNull(categoryDAO.find("Tech"));

    }

    public void testDelete() throws Exception {
        CategoryDAO categoryDAO = new CategoryDAO();
        Category inputValue = new Category();

        inputValue.setCategoryId(2);
        inputValue.setCategoryName("Refrigerator");
        inputValue.setCategoryDescription("Refrigerator description");

        categoryDAO.save(inputValue);
        Category expectedValue = categoryDAO.find("Refrigerator");

        assertEquals(inputValue, expectedValue);

        categoryDAO.delete("Refrigerator");

        assertNull(categoryDAO.find("Refrigerator"));

    }

    public void testFindName() throws Exception {

        CategoryDAO categoryDAO = new CategoryDAO();
        Category inputValue = new Category();

        inputValue.setCategoryId(3);
        inputValue.setCategoryName("Microwave");
        inputValue.setCategoryDescription("Microwave description");

        categoryDAO.save(inputValue);
        Category expectedValue = categoryDAO.find("Microwave");

        assertEquals(inputValue, expectedValue);

        categoryDAO.delete("Microwave");

        assertNull(categoryDAO.find("Microwave"));

    }

    public void testFindId() throws Exception {

        CategoryDAO categoryDAO = new CategoryDAO();
        Category inputValue = new Category();

        inputValue.setCategoryId(4);
        inputValue.setCategoryName("Kettle");
        inputValue.setCategoryDescription("Kettle description");

        categoryDAO.save(inputValue);
        Category expectedValue = categoryDAO.find(4);

        assertEquals(inputValue, expectedValue);

        categoryDAO.delete("Kettle");

        assertNull(categoryDAO.find("Kettle"));

    }
}