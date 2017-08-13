package com.kuleshov.dao;

import com.kuleshov.entity.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class CustomerDAOTest {

    private CustomerDAO customerDAO = new CustomerDAO();
    private Customer inputValue = new Customer();
    private Customer updateValue = new Customer();
    private LocalDate date = LocalDate.of(2015, 8, 11);


    @Test
    public void shouldSaveCustomer() {

        //given
        inputValue.setId(1);
        inputValue.setFirstName("Cool");
        inputValue.setLastName("Sergei");
        inputValue.setAge(new java.sql.Date(2017, 12, 30));
        inputValue.setPhone(5555555);
        inputValue.setCity("City");
        inputValue.setAddress("Address");
        inputValue.setEmail("Cool@mail.com");
        inputValue.setPassword("12345");

        //when
        boolean save = customerDAO.save(inputValue);
        Customer find = customerDAO.find(1);
        boolean delete = customerDAO.delete(1);

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(find,inputValue);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldFindCustomer() {

        //given
        inputValue.setId(1);
        inputValue.setFirstName("Cool");
        inputValue.setLastName("Sergei");
        inputValue.setAge(new java.sql.Date(2017, 12, 30));
        inputValue.setPhone(5555555);
        inputValue.setCity("City");
        inputValue.setAddress("Address");
        inputValue.setEmail("Cool@mail.com");
        inputValue.setPassword("12345");

        //when
        boolean save = customerDAO.save(inputValue);
        Customer find = customerDAO.find(1);
        boolean delete = customerDAO.delete(1);

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldFindCustomerByEmail() {

        //given
        inputValue.setId(1);
        inputValue.setFirstName("Cool");
        inputValue.setLastName("Sergei");
        inputValue.setAge(new java.sql.Date(2017, 12, 30));
        inputValue.setPhone(5555555);
        inputValue.setCity("City");
        inputValue.setAddress("Address");
        inputValue.setEmail("Cool@mail.com");
        inputValue.setPassword("12345");

        //when
        boolean save = customerDAO.save(inputValue);
        Customer find = customerDAO.findEmail("Cool@mail.com");
        boolean delete = customerDAO.delete(1);

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldUpdateCustomer() {

        //given
        inputValue.setId(1);
        inputValue.setFirstName("Cool");
        inputValue.setLastName("Sergei");
        inputValue.setAge(new java.sql.Date(2017, 12, 30));
        inputValue.setPhone(5555555);
        inputValue.setCity("City");
        inputValue.setAddress("Address");
        inputValue.setEmail("Cool@mail.com");
        inputValue.setPassword("12345");

        updateValue.setId(1);
        updateValue.setFirstName("UpdateCool");
        updateValue.setLastName("UpdateSergei");
        updateValue.setAge(new java.sql.Date(1999, 01, 20));
        updateValue.setPhone(4444444);
        updateValue.setCity("UpdateCity");
        updateValue.setAddress("UpdateAddress");
        updateValue.setEmail("UpdateCool@mail.com");
        updateValue.setPassword("Update12345");

        //when
        boolean save = customerDAO.save(inputValue);
        boolean update = customerDAO.update(updateValue);
        Customer find = customerDAO.find(1);
        boolean delete = customerDAO.delete(1);

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(update);
        Assert.assertEquals(updateValue, find);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldDeleteCustomer() {

        //given
        inputValue.setId(3);
        inputValue.setFirstName("Cool");
        inputValue.setLastName("Sergei");
        inputValue.setAge(new java.sql.Date(2017, 12, 30));
        inputValue.setPhone(5555555);
        inputValue.setCity("City");
        inputValue.setAddress("Address");
        inputValue.setEmail("Cool@mail.com");
        inputValue.setPassword("12345");

        //when
        boolean save = customerDAO.save(inputValue);
        boolean delete = customerDAO.delete(3);
        Customer findAfterDelete = customerDAO.find(3);

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
        Assert.assertNotEquals(inputValue, findAfterDelete);
    }
}