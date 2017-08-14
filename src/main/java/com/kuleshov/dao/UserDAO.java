package com.kuleshov.dao;

import com.kuleshov.entity.User;
import com.kuleshov.exception.IllegalRequestException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends AbstractDAO {
    private Logger logger = Logger.getLogger(this.getClass());
    private String SAVE_QUERY = "INSERT INTO eshop.user (CustomerID, FirstName, LastName, Age, Phone, City, Address, Email, Password) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String SELECT_BY_ID_QUERY = "SELECT CustomerID, FirstName, LastName, Age, Phone, City, Address, Email, Password FROM user " +
            "WHERE CustomerID=?";
    private String SELECT_BY_EMAIL_QUERY = "SELECT CustomerID, FirstName, LastName, Age, Phone, City, Address, Email, Password FROM user " +
            "WHERE Email=?";
    private String DELETE_QUERY = "DELETE FROM eshop.user  WHERE CustomerID=?";
    private String UPDATE_QUERY = "UPDATE eshop.user " +
            "SET FirstName=?, LastName=?, Age=?, Phone=?, City=?, Address=?, Email=?, Password=? WHERE CustomerID=?";

    public boolean save(User user) {
        try (PreparedStatement st = connection.prepareStatement(SAVE_QUERY)) {

            st.setInt(1, user.getId());
            st.setString(2, user.getFirstName());
            st.setString(3, user.getLastName());
            st.setDate(4, (user.getAge()));
            st.setInt(5, user.getPhone());
            st.setString(6, user.getCity());
            st.setString(7, user.getAddress());
            st.setString(8, user.getEmail());
            st.setString(9, user.getPassword());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't save customer with ID: " + user.getId());
            throw new IllegalRequestException("");
        }
    }

    public User find(int id) {
        try (PreparedStatement st = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            st.setLong(1, id);

            ResultSet rs = st.executeQuery();
            User user = new User();

            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge(rs.getDate(4));
                user.setPhone(rs.getInt(5));
                user.setCity(rs.getString(6));
                user.setAddress(rs.getString(7));
                user.setEmail(rs.getString(8));
                user.setPassword(rs.getString(9));

            }
            return user;
        } catch (SQLException e) {
            logger.error("Can't findEmail customer with id: " + id);
            return null;
        }
    }

    public User findEmail(String email) {
        try (PreparedStatement st = connection.prepareStatement(SELECT_BY_EMAIL_QUERY)) {
            st.setString(1, email);

            ResultSet rs = st.executeQuery();
            User user = new User();

            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge(rs.getDate(4));
                user.setPhone(rs.getInt(5));
                user.setCity(rs.getString(6));
                user.setAddress(rs.getString(7));
                user.setEmail(rs.getString(8));
                user.setPassword(rs.getString(9));

            }
            return user;
        } catch (SQLException e) {
            logger.error("Can't findEmail customer with id: " + email);
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

    public boolean update(User user) {
        try (PreparedStatement st = connection.prepareStatement(UPDATE_QUERY)) {

            st.setString(1, user.getFirstName());
            st.setString(2, user.getLastName());
            st.setDate(3, (java.sql.Date) user.getAge());
            st.setInt(4, user.getPhone());
            st.setString(5, user.getCity());
            st.setString(6, user.getAddress());
            st.setString(7, user.getEmail());
            st.setString(8, user.getPassword());
            st.setInt(9, user.getId());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't update customer with ID: " + user.getId());
            throw new IllegalRequestException("");
        }
    }
}
