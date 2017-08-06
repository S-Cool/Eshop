package com.kuleshov.dao;

import com.kuleshov.entity.Employee;
import junit.framework.TestCase;
import org.junit.Assert;

public class EmployeeDAOTest extends TestCase {

    EmployeeDAO employeeDAO = new EmployeeDAO();
    Employee inputValue = new Employee();
    Employee updateValue = new Employee();

    public void testSave() throws Exception {

        //given
        inputValue.setName("Larry");
        inputValue.setPassword("pass321");

        //when
        boolean save = employeeDAO.save(inputValue);
        boolean delete = employeeDAO.delete("Larry");

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
    }

    public void testFindName() throws Exception {

        //given
        inputValue.setName("Jonathan");
        inputValue.setPassword("pass123");

        //when
        boolean save = employeeDAO.save(inputValue);
        Employee find = employeeDAO.findName("Jonathan");
        boolean delete = employeeDAO.delete("Jonathan");

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
    }

    public void testUpdate() throws Exception {
        //given
        inputValue.setName("Smith");
        inputValue.setPassword("passSmith");

        updateValue.setName("Smith");
        updateValue.setPassword("passChange");

        //when
        boolean save = employeeDAO.save(inputValue);
        boolean update = employeeDAO.update(updateValue);
        boolean delete = employeeDAO.delete("Smith");

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(update);
        Assert.assertTrue(delete);
    }

    public void testDelete() throws Exception {

        //given
        inputValue.setName("Sergei");
        inputValue.setPassword("password");

        //when
        boolean save = employeeDAO.save(inputValue);
        boolean delete = employeeDAO.delete("Sergei");

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
    }
}