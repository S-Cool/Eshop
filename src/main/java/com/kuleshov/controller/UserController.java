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

    @RequestMapping(url = "/", method = HttpMethod.GET)
    public ModelAndView main() {
        return new ModelAndView(View.MAIN);
    }

    @RequestMapping(url = "/user/find", method = HttpMethod.GET)
    public ModelAndView findCustomerById(@RequestParam(name = "id") int id) {
        ModelAndView view = new ModelAndView(View.USER);
        User user = customerService.findUserById(id);
        view.addParameter("user", user);
        return view;
    }

    @RequestMapping(url = "/user/signUp", method = HttpMethod.POST)
    public ModelAndView signUp(@RequestParam(name = "id") int id, @RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName,
                               @RequestParam(name = "age") Date age, @RequestParam(name = "phone") int phone, @RequestParam(name = "email") String email,
                               @RequestParam(name = "city") String city, @RequestParam(name = "address") String address, @RequestParam(name = "password") String password) {
        ModelAndView view = new ModelAndView(View.REGISTRATION);
        UserDTO customer = customerService.saveUser(id, firstName, lastName, age, phone, email, city, address, password);
        view.addParameter("user", customer);
        return view;
    }

    @RequestMapping(url = "/user/signUp", method = HttpMethod.GET)
    public ModelAndView signUpGet() {
        ModelAndView view = new ModelAndView(View.REGISTRATION);
        return view;
    }

    @RequestMapping(url = "/user/login", method = HttpMethod.POST)
    public ModelAndView login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        ModelAndView view = new ModelAndView(View.LOGIN);
        UserDTO userDTO = customerService.login(email, password);

        if (userDTO != null) {
            view.setView(View.MAIN);
            view.addParameter("user", userDTO);
        }
        return view;
    }

    @RequestMapping(url = "/user/login", method = HttpMethod.GET)
    public ModelAndView getLoginPage() {
        return new ModelAndView(View.LOGIN);
    }
}
