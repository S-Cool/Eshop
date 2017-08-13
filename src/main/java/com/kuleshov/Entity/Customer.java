package com.kuleshov.entity;

import java.sql.Date;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private Date age;
    private int phone;
    private String email;
    private String city;
    private String address;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }

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

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (phone != customer.phone) return false;
        if (!address.equals(customer.address)) return false;
        if (!age.equals(customer.age)) return false;
        if (!city.equals(customer.city)) return false;
        if (!email.equals(customer.email)) return false;
        if (!firstName.equals(customer.firstName)) return false;
        if (!lastName.equals(customer.lastName)) return false;
        if (!password.equals(customer.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + phone;
        result = 31 * result + email.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
