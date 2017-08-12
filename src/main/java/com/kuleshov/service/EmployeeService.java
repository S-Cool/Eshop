package com.kuleshov.service;

import com.kuleshov.dao.EmployeeDAO;
import com.kuleshov.entity.Employee;
import com.kuleshov.web.response.EmployeeDTO;

public class EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Employee findEmployeeByName(String name) {
        return employeeDAO.find(name);
    }

    public EmployeeDTO saveEmployee(String name, String password) {
        Employee dto = new Employee();
        dto.setName(name);
        dto.setPassword(password);

        employeeDAO.save(dto);

        Employee employee = employeeDAO.find(name);
        return new EmployeeDTO(employee);
    }

    public EmployeeDTO login(String name, String password) {
        Employee employee = employeeDAO.find(name);
        if (employee == null) {
            return null;
        }
        boolean isLogined = employee.getPassword().equals(password);
        if (isLogined) {
            return new EmployeeDTO(employee);
        }
        return null;
    }
}
