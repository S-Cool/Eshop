package com.kuleshov.web.response;

import com.kuleshov.entity.Employee;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

    private String name;
    private String password;


    public EmployeeDTO(Employee employee) {
        name = employee.getName();
        password = employee.getPassword();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
