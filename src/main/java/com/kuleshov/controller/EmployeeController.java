package com.kuleshov.controller;

import com.kuleshov.annotation.RequestMapping;
import com.kuleshov.service.EmployeeService;
import com.kuleshov.web.HttpMethod;
import com.kuleshov.web.ModelAndView;
import com.kuleshov.web.View;
import com.kuleshov.web.response.EmployeeDTO;

public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(url = "/employee/find", method = HttpMethod.GET)
    public ModelAndView findEmployeeById(String name) {
        ModelAndView view = new ModelAndView(View.CATEGORY);
//        Employee category = EmployeeService.findEmployeeByName(name);
//        view.addParameter("category", category);
        return view;
    }

    @RequestMapping(url = "/employee/signUp", method = HttpMethod.POST)
    public ModelAndView signUp(String name, String password) {
        ModelAndView view = new ModelAndView(View.MAIN);
        EmployeeDTO employee = employeeService.saveEmployee(name, password);
        view.addParameter("employee", employee);
        return view;
    }

    @RequestMapping(url = "/employee/login", method = HttpMethod.POST)
    public ModelAndView login(String name, String password) {
        ModelAndView view = new ModelAndView(View.LOGIN);
        EmployeeDTO employeeDTO = employeeService.login(name, password);

        if (employeeDTO != null) {
            view.setView(View.MAIN);
            view.addParameter("user", employeeDTO);
        }
        return view;
    }
}
