package com.kuleshov.service;

import com.kuleshov.dao.UserDAO;
import com.kuleshov.entity.User;
import com.kuleshov.web.response.UserDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldFindUserById() {

        //given
        User user = new User();
        user.setId(1);
        user.setFirstName("Cool");
        user.setLastName("Sergei");
        user.setAge(new java.sql.Date(2017, 12, 30));
        user.setPhone(5555555);
        user.setCity("City");
        user.setAddress("Address");
        user.setEmail("Cool@mail.com");
        user.setPassword("12345");

        //when
        Mockito.when(userDAO.find(1)).thenReturn(user);
        User actual = userService.findUserById(1);

        //then
        Assert.assertEquals(user, actual);

        //verify
        Mockito.verify(userDAO, Mockito.times(1)).find(1);
    }

    @Test
    public void shouldSaveUser() {

        //given
        User user = new User();
        user.setId(1);
        user.setFirstName("Cool");
        user.setLastName("Sergei");
        user.setAge(new java.sql.Date(2017, 12, 30));
        user.setPhone(5555555);
        user.setEmail("Cool@mail.com");
        user.setCity("City");
        user.setAddress("Address");
        user.setPassword("12345");

        UserDTO userDTO = new UserDTO(user);

        //when
        Mockito.when(userDAO.save(user)).thenReturn(true);
        Mockito.when(userDAO.find(1)).thenReturn(user);

        UserDTO actual = userService.saveUser(1, "Cool", "Sergei", new Date(2017, 12, 30), 5555555, "Cool@mail.com", "City", "Address", "12345");

        //then
        Assert.assertEquals(userDTO, actual);

        //verify
        Mockito.verify(userDAO, Mockito.times(1)).save(user);
        Mockito.verify(userDAO, Mockito.times(1)).find(1);
    }

    @Test
    public void shouldLoginUser() {

        //given
        User user = new User();
        user.setId(1);
        user.setFirstName("Cool");
        user.setLastName("Sergei");
        user.setAge(new java.sql.Date(2017, 12, 30));
        user.setPhone(5555555);
        user.setEmail("Cool@mail.com");
        user.setCity("City");
        user.setAddress("Address");
        user.setPassword("12345");

        UserDTO userDTO = new UserDTO(user);

        //when
        Mockito.when(userDAO.findEmail("Cool@mail.com")).thenReturn(user);
        Mockito.when(userDAO.findEmail("John@mail.com")).thenReturn(null);
        UserDTO actualTrueUser = userService.login("Cool@mail.com", "12345");
        UserDTO actualFalseUser = userService.login("John@mail.com", "12345");

        //then
        Assert.assertEquals(userDTO, actualTrueUser);
        Assert.assertNull(actualFalseUser);

        //verify
        Mockito.verify(userDAO, Mockito.times(1)).findEmail("Cool@mail.com");
        Mockito.verify(userDAO, Mockito.times(1)).findEmail("John@mail.com");
    }

}