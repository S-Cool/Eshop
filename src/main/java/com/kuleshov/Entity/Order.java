package com.kuleshov.entity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (Float.compare(order.orderPrice, orderPrice) != 0) return false;
        if (shipPhone != order.shipPhone) return false;
        if (!delivery.equals(order.delivery)) return false;
        if (!orderDate.equals(order.orderDate)) return false;
        if (!paymentMethod.equals(order.paymentMethod)) return false;
        if (!shipAddress.equals(order.shipAddress)) return false;
        if (!shipCity.equals(order.shipCity)) return false;
        if (!shipDate.equals(order.shipDate)) return false;
        if (!shipEmail.equals(order.shipEmail)) return false;
        if (!shipFirstName.equals(order.shipFirstName)) return false;
        if (!shipLastName.equals(order.shipLastName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderDate.hashCode();
        result = 31 * result + shipDate.hashCode();
        result = 31 * result + paymentMethod.hashCode();
        result = 31 * result + delivery.hashCode();
        result = 31 * result + (orderPrice != +0.0f ? Float.floatToIntBits(orderPrice) : 0);
        result = 31 * result + shipFirstName.hashCode();
        result = 31 * result + shipLastName.hashCode();
        result = 31 * result + shipCity.hashCode();
        result = 31 * result + shipAddress.hashCode();
        result = 31 * result + shipEmail.hashCode();
        result = 31 * result + shipPhone;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDate=" + orderDate +
                ", shipDate=" + shipDate +
                ", paymentMethod=" + paymentMethod +
                ", delivery=" + delivery +
                ", orderPrice=" + orderPrice +
                ", shipFirstName='" + shipFirstName + '\'' +
                ", shipLastName='" + shipLastName + '\'' +
                ", shipCity='" + shipCity + '\'' +
                ", shipAddress='" + shipAddress + '\'' +
                ", shipEmail='" + shipEmail + '\'' +
                ", shipPhone=" + shipPhone +
                '}';
    }
}
