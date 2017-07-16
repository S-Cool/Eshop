package com.kuleshov.Entity;

import java.util.Date;

public class Order {
    private Date orderDate;
    private Date shipDate;
    private Enum paymentMethod;
    private Enum delivery;
    private float orderPrice;
    private String shipFirstName;
    private String shipLastName;
    private String shipCity;
    private String shipAddress;
    private String shipEmail;
    private int shipPhone;

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

    public Enum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Enum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Enum getDelivery() {
        return delivery;
    }

    public void setDelivery(Enum delivery) {
        this.delivery = delivery;
    }

    public float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
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

    public int getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(int shipPhone) {
        this.shipPhone = shipPhone;
    }
}
