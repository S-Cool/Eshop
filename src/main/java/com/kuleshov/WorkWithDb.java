package com.kuleshov;

        import com.kuleshov.Entity.Employee;

        import java.sql.*;

public class WorkWithDb {
    public static final String URL = "jdbc:mysql://localhost:3306/eshop_new2";
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
//            statement.execute("INSERT INTO customer(cust_id, fed_id, cust_type_cd, address, city, state, postal_code) " +
//                    "VALUES ('16', '05-555555', 'B', '8585 Presidential Way', 'Quincy', 'MA', '02213');");
//
////          Create Batch
//            statement.addBatch("INSERT INTO customer(cust_id, fed_id, cust_type_cd, address, city, state, postal_code) " +
//                    "VALUES ('14', '05-555555', 'B', '8585 Presidential Way', 'Quincy', 'MA', '02213');");
//            statement.addBatch("INSERT INTO customer(cust_id, fed_id, cust_type_cd, address, city, state, postal_code) " +
//                    "VALUES ('15', '05-555555', 'B', '8585 Presidential Way', 'Quincy', 'MA', '02213');");
//            statement.addBatch("INSERT INTO customer(cust_id, fed_id, cust_type_cd, address, city, state, postal_code) " +
//                    "VALUES ('16', '05-555555', 'B', '8585 Presidential Way', 'Quincy', 'MA', '02213');");
//            statement.executeBatch();
//
//            statement.clearBatch();
//
//            boolean status = statement.isClosed();
//            System.out.println(status);

//          Read
            ResultSet resultSet = statement.executeQuery("SELECT * FROM eshop_new2.employees;");
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setName(resultSet.getString("EmployeeName"));
                employee.setPassword(resultSet.getString("EmployeePassword"));
                System.out.println(employee);
            }

////          Update
//            int resUpdate = statement.executeUpdate("UPDATE bank.customer SET state='HL' WHERE cust_id='16';");
//            System.out.println(resUpdate);
//
////          Delete
//            int resDelete = statement.executeUpdate("DELETE FROM bank.customer WHERE cust_id='16';");
//            System.out.println(resDelete);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

