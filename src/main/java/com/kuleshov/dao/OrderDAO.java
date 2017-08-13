package com.kuleshov.dao;

import com.kuleshov.entity.Order;
import com.kuleshov.exception.IllegalRequestException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO extends AbstractDAO {

    private Logger logger = Logger.getLogger(this.getClass());
    private String SAVE_QUERY =
            "INSERT INTO eshop.order (OrderID, Customer_CustomerID, employees_EmployeeName, OrderDate, ShippedDate, PaymentMethods, " +
                    "Delivery, ShipFName, ShipLName, ShipPhone, ShipCity, ShipAddress, ShipEmail) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private String SELECT_BY_ID_QUERY = "SELECT OrderID, Customer_CustomerID, employees_EmployeeName, OrderDate, ShippedDate, " +
            "PaymentMethods, Delivery, ShipFName, ShipLName, ShipPhone, ShipCity, ShipAddress, ShipEmail FROM eshop.order where OrderID=?;";
    private String UPDATE_QUERY = "UPDATE eshop.order SET OrderID=?, Customer_CustomerID=?, employees_EmployeeName=?, OrderDate=?, ShippedDate=?," +
            " PaymentMethods=?, Delivery=?, ShipFName=?, ShipLName=?, ShipPhone=?, ShipCity=?, ShipAddress=?, ShipEmail=? WHERE OrderID=?;";
    private String DELETE_QUERY = "DELETE FROM eshop.order WHERE OrderID=?;";

    public boolean save(Order order) {
        try (PreparedStatement st = connection.prepareStatement(SAVE_QUERY)) {

            st.setInt(1, order.getOrderId());
            st.setInt(2, order.getCustomerCustomerId());
            st.setString(3, order.getEmployeeEmployeeName());
            st.setDate(4, (java.sql.Date) order.getOrderDate());
            st.setDate(5, (java.sql.Date) order.getShipDate());
            st.setString(6, order.getPaymentMethod());
            st.setString(7, order.getDelivery());
            st.setString(8, order.getShipFirstName());
            st.setString(9, order.getShipLastName());
            st.setInt(10, order.getShipPhone());
            st.setString(11, order.getShipCity());
            st.setString(12, order.getShipAddress());
            st.setString(13, order.getShipEmail());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't save order with ID: " + order.getOrderId());
            throw new IllegalRequestException("");
        }
    }

    public Order find(int id) {
        try (PreparedStatement st = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt(1));
                order.setCustomerCustomerId(rs.getInt(2));
                order.setEmployeeEmployeeName(rs.getString(3));
                order.setOrderDate(rs.getDate(4));
                order.setShipDate(rs.getDate(5));
                order.setPaymentMethod(rs.getString(6));
                order.setDelivery(rs.getString(7));
                order.setShipFirstName(rs.getString(8));
                order.setShipLastName(rs.getString(9));
                order.setShipPhone(rs.getInt(10));
                order.setShipCity(rs.getString(11));
                order.setShipAddress(rs.getString(12));
                order.setShipEmail(rs.getString(13));
                return order;
            }
            return null;
        } catch (SQLException e) {
            logger.error("Can't findEmail order with id: " + id);
            return null;
        }
    }

    public boolean update(Order order) {
        try (PreparedStatement st = connection.prepareStatement(UPDATE_QUERY)) {

            st.setInt(1, order.getOrderId());
            st.setInt(2, order.getCustomerCustomerId());
            st.setString(3, order.getEmployeeEmployeeName());
            st.setDate(4, (java.sql.Date) order.getOrderDate());
            st.setDate(5, (java.sql.Date) order.getShipDate());
            st.setString(6, order.getPaymentMethod());
            st.setString(7, order.getDelivery());
            st.setString(8, order.getShipFirstName());
            st.setString(9, order.getShipLastName());
            st.setInt(10, order.getShipPhone());
            st.setString(11, order.getShipCity());
            st.setString(12, order.getShipAddress());
            st.setString(13, order.getShipEmail());
            st.setInt(14, order.getOrderId());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't update order with ID: " + order.getOrderId());
            throw new IllegalRequestException("");
        }
    }

    public boolean delete(int id) {
        try (PreparedStatement st = connection.prepareStatement(DELETE_QUERY)) {
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't delete order with id: " + id);
            throw new IllegalRequestException("");
        }
    }
}
