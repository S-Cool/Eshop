package com.kuleshov;

import com.kuleshov.entity.Employee;

import java.sql.*;

public class WorkWithDb {
    public static final String URL = "jdbc:mysql://localhost:3306/eshop";
    public static final String USERNAME = "root";
    public static final String USERPASSWORD = "admin111";

    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
            Statement statement = connection.createStatement();

////          Create
//            statement.execute("INSERT INTO eshop.employees (EmployeeName, EmployeePassword) VALUES ('admin', '12345');");

////          Create Batch
//            statement.addBatch("INSERT INTO eshop.employees (EmployeeName, EmployeePassword) VALUES ('Ivan', '54321');");
//            statement.addBatch("INSERT INTO eshop.employees (EmployeeName, EmployeePassword) VALUES ('Steve', 'qwerty');");
//            statement.addBatch("INSERT INTO eshop.employees (EmployeeName, EmployeePassword) VALUES ('Alena', 'ytrewq');");
//            statement.executeBatch();
//            statement.clearBatch();
//
//            boolean status = statement.isClosed();
//            System.out.println(status);


//          Update
            int resUpdate = statement.executeUpdate("UPDATE eshop.employees SET EmployeePassword='change' WHERE EmployeeName='Steve';");
            System.out.println(resUpdate);

//          Delete
            int resDelete = statement.executeUpdate("DELETE FROM eshop.employees WHERE EmployeeName='Steve';\n");
            System.out.println(resDelete);

//          Read
            ResultSet resultSet = statement.executeQuery("SELECT * FROM eshop.employees;");
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setName(resultSet.getString("EmployeeName"));
                employee.setPassword(resultSet.getString("EmployeePassword"));
                System.out.println(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

