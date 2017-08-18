package com.kuleshov.web.response;

import com.kuleshov.entity.User;

import java.io.Serializable;
import java.sql.Date;

public class UserDTO implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private Date age;
    private int phone;
    private String city;
    private String address;
    private String email;
    private String password;

    public UserDTO(User user) {
        id = user.getId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        age = user.getAge();
        phone = user.getPhone();
        city = user.getCity();
        address = user.getAddress();
        email = user.getEmail();
        password = user.getPassword();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (id != userDTO.id) return false;
        if (!email.equals(userDTO.email)) return false;
        if (!password.equals(userDTO.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
