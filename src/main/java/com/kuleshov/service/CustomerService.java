package com.kuleshov.service;

import com.kuleshov.dao.CustomerDAO;
import com.kuleshov.entity.Customer;
import com.kuleshov.web.response.CustomerDTO;

import java.sql.Date;

public class CustomerService {

    private CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Customer findCustomerById(int id) {
        return customerDAO.find(id);
    }

    public CustomerDTO saveCustomer(int id, String firstName, String lastName, Date age, int phone, String email, String city,
                                    String address, String password) {
        Customer dto = new Customer();
        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setAge(age);
        dto.setPhone(phone);
        dto.setEmail(email);
        dto.setCity(city);
        dto.setAddress(address);
        dto.setPassword(password);

        customerDAO.save(dto);

        Customer customer = customerDAO.find(id);
        return new CustomerDTO(customer);
    }

    public CustomerDTO login(String email, String password) {
        Customer customer = customerDAO.findEmail(email);
        if (customer == null) {
            return null;
        }
        boolean isLogined = customer.getPassword().equals(password);
        if (isLogined) {
            return new CustomerDTO(customer);
        }
        return null;
    }
}
