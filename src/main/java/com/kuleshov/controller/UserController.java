package com.kuleshov.controller;

import com.kuleshov.annotation.RequestMapping;
import com.kuleshov.annotation.RequestParam;
import com.kuleshov.entity.User;
import com.kuleshov.service.UserService;
import com.kuleshov.web.Controller;
import com.kuleshov.web.HttpMethod;
import com.kuleshov.web.ModelAndView;
import com.kuleshov.web.View;
import com.kuleshov.web.response.UserDTO;

import java.sql.Date;

public class UserController implements Controller {

    private UserService customerService;

    public UserController(UserService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(url = "/user/findEmail", method = HttpMethod.GET)
    public ModelAndView findCustomerById(@RequestParam(name = "id") int id) {
        ModelAndView view = new ModelAndView(View.USER);
        User user = customerService.findUserById(id);
        view.addParameter("user", user);
        return view;
    }

    @RequestMapping(url = "/user/signUp", method = HttpMethod.POST)
    public ModelAndView signUp(int id, String firstName, String lastName, Date age, int phone, String email, String city, String address, String password) {
        ModelAndView view = new ModelAndView(View.MAIN);
        UserDTO customer = customerService.saveUser(id, firstName, lastName, age, phone, email, city, address, password);
        view.addParameter("user", customer);
        return view;
    }

    @RequestMapping(url = "/user/login", method = HttpMethod.POST)
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
