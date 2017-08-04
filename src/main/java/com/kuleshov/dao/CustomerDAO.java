package com.kuleshov.dao;

import com.kuleshov.entity.Category;
import com.kuleshov.entity.Customer;
import com.kuleshov.exception.IllegalRequestException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO extends AbstractDAO {
    private Logger logger = Logger.getLogger(this.getClass());
    private String SAVE_QUERY = "INSERT INTO eshop.customer (CustomerID, FirstName, LastName, Age, Phone, City, Address, Email, Password) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String SELECT_BY_ID_QUERY = "SELECT CustomerID, FirstName, LastName, Age, Phone, City, Address, Email, Password FROM customer " +
            "WHERE CustomerID=?";
    private String DELETE_QUERY = "DELETE FROM eshop.customer  WHERE CustomerID=?";
    private String UPDATE_QUERY = "UPDATE eshop.customer " +
            "SET FirstName=?, LastName=?, Age=?, Phone=?, City=?, Address=?, Email=?, Password=? WHERE CustomerID=?";

    public boolean save(Customer customer) {
        try (PreparedStatement st = connection.prepareStatement(SAVE_QUERY)) {

            st.setInt(1, customer.getId());
            st.setString(2, customer.getFirstName());
            st.setString(3, customer.getLastName());
            st.setDate(4, (java.sql.Date) customer.getAge());
            st.setInt(5, customer.getPhone());
            st.setString(6, customer.getCity());
            st.setString(7, customer.getAdress());
            st.setString(8, customer.getEmail());
            st.setString(9, customer.getPassword());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't save customer with ID: " + customer.getId());
            throw new IllegalRequestException("");
        }
    }

    public Customer findId(int id) {
        try (PreparedStatement st = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            st.setLong(1, id);

            ResultSet rs = st.executeQuery();
            Customer customer = new Customer();

            while (rs.next()) {
                customer.setId(rs.getInt(1));
                customer.setFirstName(rs.getString(2));
                customer.setLastName(rs.getString(3));
                customer.setAge(rs.getDate(4));
                customer.setPhone(rs.getInt(5));
                customer.setCity(rs.getString(6));
                customer.setAdress(rs.getString(7));
                customer.setEmail(rs.getString(8));
                customer.setPassword(rs.getString(9));

            }
            return customer;
        } catch (SQLException e) {
            logger.error("Can't find customer with id: " + id);
            return null;
        }
    }

    public boolean delete(int id) {
        try (PreparedStatement st = connection.prepareStatement(DELETE_QUERY)) {
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't delete customer with id: " + id);
            throw new IllegalRequestException("");
        }
    }

    public boolean update(Customer customer) {
        try (PreparedStatement st = connection.prepareStatement(UPDATE_QUERY)) {

            st.setString(1, customer.getFirstName());
            st.setString(2, customer.getLastName());
            st.setDate(3, (java.sql.Date) customer.getAge());
            st.setInt(4, customer.getPhone());
            st.setString(5, customer.getCity());
            st.setString(6, customer.getAdress());
            st.setString(7, customer.getEmail());
            st.setString(8, customer.getPassword());
            st.setInt(9, customer.getId());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't update customer with ID: " + customer.getId());
            throw new IllegalRequestException("");
        }
    }
}
