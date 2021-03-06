package main.java.com.kuleshov.dao;

import com.kuleshov.dao.UserDAO;
import com.kuleshov.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class UserDAOTest {

    private UserDAO userDAO = new UserDAO();
    private User inputValue = new User();
    private User updateValue = new User();
    private LocalDate date = LocalDate.of(2015, 8, 11);


    @Test
    public void shouldSaveUser() {

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
        boolean save = userDAO.save(inputValue);
        User find = userDAO.find(1);
        boolean delete = userDAO.delete(1);

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(find, inputValue);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldFindUser() {

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
        boolean save = userDAO.save(inputValue);
        User find = userDAO.find(1);
        boolean delete = userDAO.delete(1);

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldFindUserByEmail() {

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
        boolean save = userDAO.save(inputValue);
        User find = userDAO.find("Cool@mail.com");
        boolean delete = userDAO.delete(1);

        //then
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldUpdateUser() {

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
        boolean save = userDAO.save(inputValue);
        boolean update = userDAO.update(updateValue);
        User find = userDAO.find(1);
        boolean delete = userDAO.delete(1);

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(update);
        Assert.assertEquals(updateValue, find);
        Assert.assertTrue(delete);
    }

    @Test
    public void shouldDeleteUser() {

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
        boolean save = userDAO.save(inputValue);
        boolean delete = userDAO.delete(3);
        User findAfterDelete = userDAO.find(3);

        //then
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
        Assert.assertNotEquals(inputValue, findAfterDelete);
    }
}