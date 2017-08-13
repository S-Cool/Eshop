package com.kuleshov.controller;

import com.kuleshov.annotation.RequestMapping;
import com.kuleshov.service.CustomerService;
import com.kuleshov.web.HttpMethod;
import com.kuleshov.web.ModelAndView;
import com.kuleshov.web.View;
import com.kuleshov.web.response.CustomerDTO;

import java.sql.Date;

public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(url = "/customer/findEmail", method = HttpMethod.GET)
    public ModelAndView findCustomerById(int id) {
        ModelAndView view = new ModelAndView(View.CATEGORY);
//        Customer customer = CustomerService.findCustomerById(id);
//        view.addParameter("customer", customer);
        return view;
    }

    @RequestMapping(url = "/customer/signUp", method = HttpMethod.POST)
    public ModelAndView signUp(int id, String firstName, String lastName, Date age, int phone, String email, String city, String address, String password) {
        ModelAndView view = new ModelAndView(View.MAIN);
        CustomerDTO customer = customerService.saveCustomer(id, firstName, lastName, age, phone, email, city, address, password);
        view.addParameter("customer", customer);
        return view;
    }

    @RequestMapping(url = "/customer/login", method = HttpMethod.POST)
    public ModelAndView login(String email, String password) {
        ModelAndView view = new ModelAndView(View.LOGIN);
        CustomerDTO customerDTO = customerService.login(email, password);

        if (customerDTO != null) {
            view.setView(View.MAIN);
            view.addParameter("customer", customerDTO);
        }
        return view;
    }
}
