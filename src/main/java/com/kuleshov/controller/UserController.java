package com.kuleshov.controller;

import com.kuleshov.annotation.RequestMapping;
import com.kuleshov.entity.User;
import com.kuleshov.service.UserService;
import com.kuleshov.web.HttpMethod;
import com.kuleshov.web.ModelAndView;
import com.kuleshov.web.View;
import com.kuleshov.web.response.UserDTO;

import java.sql.Date;

public class UserController {

    private UserService customerService;

    public UserController(UserService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(url = "/customer/findEmail", method = HttpMethod.GET)
    public ModelAndView findCustomerById(int id) {
        ModelAndView view = new ModelAndView(View.USER);
        User user = customerService.findCustomerById(id);
        view.addParameter("user", user);
        return view;
    }

    @RequestMapping(url = "/customer/signUp", method = HttpMethod.POST)
    public ModelAndView signUp(int id, String firstName, String lastName, Date age, int phone, String email, String city, String address, String password) {
        ModelAndView view = new ModelAndView(View.MAIN);
        UserDTO customer = customerService.saveCustomer(id, firstName, lastName, age, phone, email, city, address, password);
        view.addParameter("user", customer);
        return view;
    }

    @RequestMapping(url = "/customer/login", method = HttpMethod.POST)
    public ModelAndView login(String email, String password) {
        ModelAndView view = new ModelAndView(View.LOGIN);
        UserDTO userDTO = customerService.login(email, password);

        if (userDTO != null) {
            view.setView(View.MAIN);
            view.addParameter("user", userDTO);
        }
        return view;
    }
}