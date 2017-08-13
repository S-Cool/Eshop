package com.kuleshov.dao;

import com.kuleshov.entity.Product;
import com.kuleshov.exception.IllegalRequestException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO extends AbstractDAO {

    private Logger logger = Logger.getLogger(this.getClass());
    private String SAVE_QUERY = "INSERT INTO eshop.products (ProductID, ProductName, QuantityInStock, Price, Description, Brand, Category_CategoryID) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";
    private String SELECT_BY_ID_QUERY = "SELECT ProductID, ProductName, QuantityInStock, Price, Description, Brand, Category_CategoryID " +
            "FROM products WHERE ProductID=?";
    private String UPDATE_QUERY = "UPDATE eshop.products " +
            "SET ProductID=?, ProductName=?, QuantityInStock=?, Price=?, Description=?, Brand=?, Category_CategoryID=? WHERE ProductID=?;";
    private String DELETE_QUERY = "DELETE FROM eshop.products WHERE ProductID=?;";

    public boolean save(Product product) {
        try (PreparedStatement st = connection.prepareStatement(SAVE_QUERY)) {

            st.setString(1, product.getProductId());
            st.setString(2, product.getProductName());
            st.setInt(3, product.getQuantityInStock());
            st.setInt(4, product.getPrice());
            st.setString(5, product.getDescription());
            st.setString(6, product.getBrand());
            st.setInt(7, product.getCategoryCategoryId());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't save product with ID: " + product.getProductId());
            throw new IllegalRequestException("");
        }
    }

    public Product findId(String id) {
        try (PreparedStatement st = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            st.setString(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString(1));
                product.setProductName(rs.getString(2));
                product.setQuantityInStock(rs.getInt(3));
                product.setPrice(rs.getInt(4));
                product.setDescription(rs.getString(5));
                product.setBrand(rs.getString(6));
                product.setCategoryCategoryId(rs.getInt(7));
                return product;
            }
            return null;
        } catch (SQLException e) {
            logger.error("Can't findEmail product with ID: " + id);
            return null;
        }
    }

    public boolean update(Product product) {
        try (PreparedStatement st = connection.prepareStatement(UPDATE_QUERY)) {

            st.setString(1, product.getProductId());
            st.setString(2, product.getProductName());
            st.setInt(3, product.getQuantityInStock());
            st.setInt(4, product.getPrice());
            st.setString(5, product.getDescription());
            st.setString(6, product.getBrand());
            st.setInt(7, product.getCategoryCategoryId());
            st.setString(8, product.getProductId());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't update product with ID: " + product.getProductId());
            throw new IllegalRequestException("");
        }
    }

    public boolean delete(String id) {
        try (PreparedStatement st = connection.prepareStatement(DELETE_QUERY)) {
            st.setString(1, id);

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't delete product with id: " + id);
            throw new IllegalRequestException("");
        }
    }
}
