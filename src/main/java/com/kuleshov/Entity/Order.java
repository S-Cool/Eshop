package com.kuleshov.entity;

import java.util.Date;

public class Order {
    private int orderId;
    private int customerCustomerId;
    private String employeeEmployeeName;
    private Date orderDate;
    private Date shipDate;
    private String paymentMethod;
    private String delivery;
    private String shipFirstName;
    private String shipLastName;
    private int shipPhone;
    private String shipCity;
    private String shipAddress;
    private String shipEmail;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public int getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(int shipPhone) {
        this.shipPhone = shipPhone;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerCustomerId() {
        return customerCustomerId;
    }

    public void setCustomerCustomerId(int customerCustomerId) {
        this.customerCustomerId = customerCustomerId;
    }

    public String getEmployeeEmployeeName() {
        return employeeEmployeeName;
    }

    public void setEmployeeEmployeeName(String employeeEmployeeName) {
        this.employeeEmployeeName = employeeEmployeeName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }


    public String getShipFirstName() {
        return shipFirstName;
    }

    public void setShipFirstName(String shipFirstName) {
        this.shipFirstName = shipFirstName;
    }

    public String getShipLastName() {
        return shipLastName;
    }

    public void setShipLastName(String shipLastName) {
        this.shipLastName = shipLastName;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipEmail() {
        return shipEmail;
    }

    public void setShipEmail(String shipEmail) {
        this.shipEmail = shipEmail;
    }


}
