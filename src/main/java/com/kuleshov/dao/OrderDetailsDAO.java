package com.kuleshov.dao;

import com.kuleshov.entity.OrderDetails;
import com.kuleshov.exception.IllegalRequestException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsDAO extends AbstractDAO {

    private Logger logger = Logger.getLogger(this.getClass());
    private String SAVE_QUERY = "INSERT INTO eshop.orderproducts (OrderProductID, ProductID, OrderID, UnitPrice, Quantity, Discount) " +
            "VALUES (?, ?, ?, ?, ?, ?);";
    private String SELECT_BY_ID_QUERY = "SELECT OrderProductID, ProductID, OrderID, UnitPrice, Quantity, Discount " +
            "FROM orderproducts WHERE OrderProductID=?";
    private String UPDATE_QUERY = "UPDATE eshop.orderproducts SET OrderProductID=?, ProductID=?, OrderID=?, UnitPrice=?, Quantity=?, Discount=? " +
            "WHERE OrderProductID=?;";
    private String DELETE_QUERY = "DELETE FROM eshop.orderproducts WHERE OrderProductID=?;";

    public boolean save(OrderDetails orderDetails) {
        try (PreparedStatement st = connection.prepareStatement(SAVE_QUERY)) {

            st.setInt(1, orderDetails.getOrderDetailsId());
            st.setString(2, orderDetails.getProductId());
            st.setInt(3, orderDetails.getOrderId());
            st.setFloat(4, orderDetails.getUnitPrice());
            st.setInt(5, orderDetails.getQuantity());
            st.setInt(6, orderDetails.getDiscount());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't save orderDetails with ID: " + orderDetails.getProductId());
            throw new IllegalRequestException("");
        }
    }

    public OrderDetails find(int id) {
        try (PreparedStatement st = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            OrderDetails orderDetails = null;

            while (rs.next()) {
                orderDetails = new OrderDetails();
                orderDetails.setOrderDetailsId(rs.getInt(1));
                orderDetails.setProductId(rs.getString(2));
                orderDetails.setOrderId(rs.getInt(3));
                orderDetails.setUnitPrice(rs.getFloat(4));
                orderDetails.setQuantity(rs.getInt(5));
                orderDetails.setDiscount(rs.getInt(6));
                return orderDetails;
            }
            return null;
        } catch (SQLException e) {
            logger.error("Can't find orderDetails with id: " + id);
            return null;
        }
    }

    public boolean update(OrderDetails orderDetails) {
        try (PreparedStatement st = connection.prepareStatement(UPDATE_QUERY)) {

            st.setInt(1, orderDetails.getOrderDetailsId());
            st.setString(2, orderDetails.getProductId());
            st.setInt(3, orderDetails.getOrderId());
            st.setFloat(4, orderDetails.getUnitPrice());
            st.setInt(5, orderDetails.getQuantity());
            st.setInt(6, orderDetails.getDiscount());
            st.setInt(7, orderDetails.getOrderDetailsId());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't update orderDetails with ID: " + orderDetails.getOrderDetailsId());
            throw new IllegalRequestException("");
        }
    }

    public boolean delete(int id) {
        try (PreparedStatement st = connection.prepareStatement(DELETE_QUERY)) {
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't delete orderDetails with id: " + id);
            throw new IllegalRequestException("");
        }
    }
}
