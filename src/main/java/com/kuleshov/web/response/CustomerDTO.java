package com.kuleshov.web.response;

import com.kuleshov.entity.Customer;

import java.io.Serializable;
import java.sql.Date;

public class CustomerDTO implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private Date age;
    private int phone;
    private String email;
    private String city;
    private String address;
    private String password;


    public CustomerDTO(Customer customer) {
        id = customer.getId();
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
        age = customer.getAge();
        phone = customer.getPhone();
        email = customer.getEmail();
        city = customer.getCity();
        address = customer.getAddress();
        password = customer.getPassword();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
