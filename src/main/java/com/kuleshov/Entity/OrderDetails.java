package com.kuleshov.entity;

public class OrderDetails {
    private float unitPrice;
    private int quantity;
    private int discount;

    public float getUnitPrice() { return unitPrice; }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetails that = (OrderDetails) o;

        if (discount != that.discount) return false;
        if (quantity != that.quantity) return false;
        if (Float.compare(that.unitPrice, unitPrice) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (unitPrice != +0.0f ? Float.floatToIntBits(unitPrice) : 0);
        result = 31 * result + quantity;
        result = 31 * result + discount;
        return result;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}
