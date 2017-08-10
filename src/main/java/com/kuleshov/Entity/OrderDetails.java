package com.kuleshov.entity;

public class OrderDetails {

    private int OrderDetailsId;
    private String productId;
    private int orderId;
    private float unitPrice;
    private int quantity;
    private int discount;

    public int getOrderDetailsId() {
        return OrderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        OrderDetailsId = orderDetailsId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

        if (OrderDetailsId != that.OrderDetailsId) return false;
        if (discount != that.discount) return false;
        if (orderId != that.orderId) return false;
        if (quantity != that.quantity) return false;
        if (Float.compare(that.unitPrice, unitPrice) != 0) return false;
        if (!productId.equals(that.productId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = OrderDetailsId;
        result = 31 * result + productId.hashCode();
        result = 31 * result + orderId;
        result = 31 * result + (unitPrice != +0.0f ? Float.floatToIntBits(unitPrice) : 0);
        result = 31 * result + quantity;
        result = 31 * result + discount;
        return result;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "OrderDetailsId=" + OrderDetailsId +
                ", productId='" + productId + '\'' +
                ", orderId=" + orderId +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}
