package com.kuleshov.dao;

import com.kuleshov.entity.Employee;
import com.kuleshov.exception.IllegalRequestException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO extends AbstractDAO {

    private Logger logger = Logger.getLogger(this.getClass());
    private String SAVE_QUERY = "INSERT INTO eshop.employees (EmployeeName, EmployeePassword) VALUES (?, ?);";
    private String SELECT_BY_NAME_QUERY = "SELECT EmployeeName, EmployeePassword FROM employees WHERE EmployeeName=?";
    private String DELETE_QUERY = "DELETE FROM eshop.employees WHERE EmployeeName=?;";
    private String UPDATE_QUERY = "UPDATE eshop.employees SET EmployeeName=?, EmployeePassword=? WHERE EmployeeName=?;";

    public boolean save(Employee employee) {
        try (PreparedStatement st = connection.prepareStatement(SAVE_QUERY)) {

            st.setString(1, employee.getName());
            st.setString(2, employee.getPassword());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't save employee with name: " + employee.getName());
            throw new IllegalRequestException("");
        }
    }

    public Employee find(String name) {
        try (PreparedStatement st = connection.prepareStatement(SELECT_BY_NAME_QUERY)) {
            st.setString(1, name);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setName(rs.getString(1));
                employee.setPassword(rs.getString(2));
                return employee;
            }
            return null;
        } catch (SQLException e) {
            logger.error("Can't findEmail employee with name: " + name);
            return null;
        }
    }

    public boolean update(Employee employee) {
        try (PreparedStatement st = connection.prepareStatement(UPDATE_QUERY)) {

            st.setString(1, employee.getName());
            st.setString(2, employee.getPassword());
            st.setString(3, employee.getName());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't update employee with name: " + employee.getName());
            throw new IllegalRequestException("");
        }
    }

    public boolean delete(String name) {
        try (PreparedStatement st = connection.prepareStatement(DELETE_QUERY)) {
            st.setString(1, name);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't delete employee with name: " + name);
            throw new IllegalRequestException("");
        }
    }
}
