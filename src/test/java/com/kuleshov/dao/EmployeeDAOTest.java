package com.kuleshov.dao;

import com.kuleshov.entity.Employee;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeDAOTest {

    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private Employee inputValue = new Employee();
    private Employee updateValue = new Employee();

    @Test
    public void shouldSaveEmployee() {

        //given
        inputValue.setName("Larry");
        inputValue.setPassword("pass321");

        //when
        boolean save = employeeDAO.save(inputValue);
        Employee find = employeeDAO.findName("Larry");
        boolean delete = employeeDAO.delete("Larry");

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(find,inputValue);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldFindEmployee() {

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

    @Test
    public void shouldUpdateEmployee() {

        //given
        inputValue.setName("Smith");
        inputValue.setPassword("passSmith");

        updateValue.setName("Smith");
        updateValue.setPassword("passChange");

        //when
        boolean save = employeeDAO.save(inputValue);
        boolean update = employeeDAO.update(updateValue);
        Employee find = employeeDAO.findName("Smith");
        boolean delete = employeeDAO.delete("Smith");

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(update);
        Assert.assertEquals(updateValue, find);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldDeleteEmployee() {

        //given
        inputValue.setName("Sergei");
        inputValue.setPassword("password");

        //when
        boolean save = employeeDAO.save(inputValue);
        boolean delete = employeeDAO.delete("Sergei");
        Employee findAfterDelete = employeeDAO.findName("Smith");

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
        Assert.assertNotEquals(inputValue, findAfterDelete);
    }
}