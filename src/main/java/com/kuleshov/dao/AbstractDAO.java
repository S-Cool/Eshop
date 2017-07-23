package com.kuleshov.dao;

import com.kuleshov.util.JDBCFactory;

import java.sql.Connection;

public class AbstractDAO<T> {
    protected Connection connection = JDBCFactory.getConnection();

}
