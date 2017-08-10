package com.kuleshov.entity;

public class Product {

    private String productId;
    private String productName;
    private int quantityInStock;
    private int price;
    private String description;
    private String brand;
    private int categoryCategoryId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCategoryCategoryId() {
        return categoryCategoryId;
    }

    public void setCategoryCategoryId(int categoryCategoryId) {
        this.categoryCategoryId = categoryCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (categoryCategoryId != product.categoryCategoryId) return false;
        if (price != product.price) return false;
        if (quantityInStock != product.quantityInStock) return false;
        if (!brand.equals(product.brand)) return false;
        if (!description.equals(product.description)) return false;
        if (!productId.equals(product.productId)) return false;
        if (!productName.equals(product.productName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + productName.hashCode();
        result = 31 * result + quantityInStock;
        result = 31 * result + price;
        result = 31 * result + description.hashCode();
        result = 31 * result + brand.hashCode();
        result = 31 * result + categoryCategoryId;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", categoryCategoryId=" + categoryCategoryId +
                '}';
    }
}
