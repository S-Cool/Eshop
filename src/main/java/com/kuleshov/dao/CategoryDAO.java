package com.kuleshov.dao;

import com.kuleshov.entity.Category;
import com.kuleshov.exception.IllegalRequestException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO extends AbstractDAO {

    private Logger logger = Logger.getLogger(this.getClass());
    private String SAVE_QUERY = "INSERT INTO eshop.category (CategoryID, CategoryName, CategoryDescription) VALUES (?, ?, ?);";
    private String SELECT_BY_ID_QUERY = "SELECT CategoryID, CategoryName, CategoryDescription FROM category WHERE CategoryID=?";
    private String SELECT_BY_NAME_QUERY = "SELECT CategoryID, CategoryName, CategoryDescription FROM category WHERE CategoryName=?";
    private String DELETE_QUERY = "DELETE FROM eshop.category  WHERE CategoryName=?";
    private String UPDATE_QUERY = "UPDATE eshop.category SET CategoryName=?, CategoryDescription=? WHERE CategoryID=?";


    public boolean save(Category category) {
        try (PreparedStatement st = connection.prepareStatement(SAVE_QUERY)) {

            st.setInt(1, category.getCategoryId());
            st.setString(2, category.getCategoryName());
            st.setString(3, category.getCategoryDescription());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't save category with name: " + category.getCategoryName());
            throw new IllegalRequestException("");
        }
    }

    public boolean delete(String name) {
        try (PreparedStatement st = connection.prepareStatement(DELETE_QUERY)) {
            st.setString(1, name);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't delete category with name: " + name);
            throw new IllegalRequestException("");
        }
    }

    public Category find(int id) {
        try (PreparedStatement st = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            st.setLong(1, id);

            ResultSet rs = st.executeQuery();
            Category category = new Category();

            while (rs.next()) {
                category.setCategoryId(rs.getInt(1));
                category.setCategoryName(rs.getString(2));
                category.setCategoryDescription(rs.getString(3));
            }
            return category;
        } catch (SQLException e) {
            logger.error("Can't findEmail category with id: " + id);
            return null;
        }
    }

    public Category find(String name) {
        try (PreparedStatement st = connection.prepareStatement(SELECT_BY_NAME_QUERY)) {
            st.setString(1, name);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getInt(1));
                category.setCategoryName(rs.getString(2));
                category.setCategoryDescription(rs.getString(3));
                return category;
            }
            return null;
        } catch (SQLException e) {
            logger.error("Can't findEmail category with name: " + name);
            return null;
        }
    }

    public boolean update(Category category) {
        try (PreparedStatement st = connection.prepareStatement(UPDATE_QUERY)) {

            st.setString(1, category.getCategoryName());
            st.setString(2, category.getCategoryDescription());
            st.setInt(3, category.getCategoryId());

            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error("Can't update category with ID: " + category.getCategoryId());
            throw new IllegalRequestException("");
        }
    }
}

