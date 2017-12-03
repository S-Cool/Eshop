package com.kuleshov.service;

import com.kuleshov.dao.UserDAO;
import com.kuleshov.entity.User;
import com.kuleshov.web.response.UserDTO;

import java.sql.Date;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User findUserById(int id) {
        return userDAO.find(id);
    }

    public UserDTO saveUser(int id, String firstName, String lastName, Date age, int phone, String email, String city,
                            String address, String password) {
        User dto = new User();
        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setAge(age);
        dto.setPhone(phone);
        dto.setCity(city);
        dto.setAddress(address);
        dto.setEmail(email);
        dto.setPassword(password);

        userDAO.save(dto);

        User user = userDAO.find(id);
        return new UserDTO(user);
    }

    public UserDTO login(String email, String password) {
        User user = userDAO.find(email);
        if (user == null) {
            return null;
        }
        boolean isLogined = user.getPassword().equals(password);
        if (isLogined) {
            return new UserDTO(user);
        }
        return null;
    }
}
