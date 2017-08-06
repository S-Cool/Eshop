package com.kuleshov.dao;

import com.kuleshov.entity.*;
import junit.framework.TestCase;
import org.junit.Assert;

public class OrderDAOTest extends TestCase {

    CustomerDAO customerDAO = new CustomerDAO();
    Customer customer = new Customer();

    EmployeeDAO employeeDAO = new EmployeeDAO();
    Employee employee = new Employee();

    OrderDAO orderDAO = new OrderDAO();
    Order inputValue = new Order();
    Order updateValue = new Order();

    public void testSave() throws Exception {
        //given
        customer.setId(1);
        customer.setFirstName("Cool");
        customer.setLastName("Sergei");
        customer.setAge(new java.sql.Date(2017, 12, 30));
        customer.setPhone(5555555);
        customer.setCity("City");
        customer.setAddress("Address");
        customer.setEmail("Cool@mail.com");
        customer.setPassword("12345");

        employee.setName("Peter");
        employee.setPassword("pass321");

        inputValue.setOrderId(1);
        inputValue.setCustomerCustomerId(1);
        inputValue.setEmployeeEmployeeName("Peter");
        inputValue.setOrderDate(new java.sql.Date(2010, 06, 30));
        inputValue.setShipDate(new java.sql.Date(2019, 10, 30));
        inputValue.setPaymentMethod("ship");
        inputValue.setDelivery("delivery");
        inputValue.setShipFirstName("Fname");
        inputValue.setShipLastName("Lname");
        inputValue.setShipPhone(5555555);
        inputValue.setShipCity("city");
        inputValue.setShipAddress("address");
        inputValue.setShipEmail("mail");

        //when
        boolean saveCustomer = customerDAO.save(customer);
        boolean saveEmployee = employeeDAO.save(employee);
        boolean save = orderDAO.save(inputValue);
        boolean delete = orderDAO.delete(1);
        boolean deleteEmployee = employeeDAO.delete("Peter");
        boolean deleteCustomer = customerDAO.delete(1);

        //then
        Assert.assertTrue(saveCustomer);
        Assert.assertTrue(saveEmployee);
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteEmployee);
        Assert.assertTrue(deleteCustomer);
    }

    public void testFindId() throws Exception {
        //given
        customer.setId(3);
        customer.setFirstName("Cool");
        customer.setLastName("Sergei");
        customer.setAge(new java.sql.Date(2017, 12, 30));
        customer.setPhone(5555555);
        customer.setCity("City");
        customer.setAddress("Address");
        customer.setEmail("Cool@mail.com");
        customer.setPassword("12345");

        employee.setName("Jon");
        employee.setPassword("pass321");

        inputValue.setOrderId(3);
        inputValue.setCustomerCustomerId(3);
        inputValue.setEmployeeEmployeeName("Jon");
        inputValue.setOrderDate(new java.sql.Date(2010, 06, 30));
        inputValue.setShipDate(new java.sql.Date(2019, 10, 30));
        inputValue.setPaymentMethod("ship");
        inputValue.setDelivery("delivery");
        inputValue.setShipFirstName("Fname");
        inputValue.setShipLastName("Lname");
        inputValue.setShipPhone(5555555);
        inputValue.setShipCity("city");
        inputValue.setShipAddress("address");
        inputValue.setShipEmail("mail");

        //when
        boolean saveCustomer = customerDAO.save(customer);
        boolean saveEmployee = employeeDAO.save(employee);
        boolean save = orderDAO.save(inputValue);
        Order find = orderDAO.findId(3);
        boolean delete = orderDAO.delete(3);
        boolean deleteEmployee = employeeDAO.delete("Jon");
        boolean deleteCustomer = customerDAO.delete(3);

        //then
        Assert.assertTrue(saveCustomer);
        Assert.assertTrue(saveEmployee);
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteEmployee);
        Assert.assertTrue(deleteCustomer);
    }

    public void testUpdate() throws Exception {
        //given
        customer.setId(4);
        customer.setFirstName("Cool");
        customer.setLastName("Sergei");
        customer.setAge(new java.sql.Date(2017, 12, 30));
        customer.setPhone(5555555);
        customer.setCity("City");
        customer.setAddress("Address");
        customer.setEmail("Cool@mail.com");
        customer.setPassword("12345");

        employee.setName("Jenny");
        employee.setPassword("pass321");

        inputValue.setOrderId(4);
        inputValue.setCustomerCustomerId(4);
        inputValue.setEmployeeEmployeeName("Jenny");
        inputValue.setOrderDate(new java.sql.Date(2010, 06, 30));
        inputValue.setShipDate(new java.sql.Date(2019, 10, 30));
        inputValue.setPaymentMethod("ship");
        inputValue.setDelivery("delivery");
        inputValue.setShipFirstName("Fname");
        inputValue.setShipLastName("Lname");
        inputValue.setShipPhone(5555555);
        inputValue.setShipCity("city");
        inputValue.setShipAddress("address");
        inputValue.setShipEmail("mail");

        updateValue.setOrderId(4);
        updateValue.setCustomerCustomerId(4);
        updateValue.setEmployeeEmployeeName("Jenny");
        updateValue.setOrderDate(new java.sql.Date(2019, 10, 30));
        updateValue.setShipDate(new java.sql.Date(2190, 12, 11));
        updateValue.setPaymentMethod("newship");
        updateValue.setDelivery("newdelivery");
        updateValue.setShipFirstName("newFname");
        updateValue.setShipLastName("newLname");
        updateValue.setShipPhone(4444444);
        updateValue.setShipCity("newCity");
        updateValue.setShipAddress("newAddress");
        updateValue.setShipEmail("newMail");

        //when
        boolean saveCustomer = customerDAO.save(customer);
        boolean saveEmployee = employeeDAO.save(employee);
        boolean save = orderDAO.save(inputValue);
        boolean update = orderDAO.update(updateValue);
        boolean delete = orderDAO.delete(4);
        boolean deleteEmployee = employeeDAO.delete("Jenny");
        boolean deleteCustomer = customerDAO.delete(4);

        //then
        Assert.assertTrue(saveCustomer);
        Assert.assertTrue(saveEmployee);
        Assert.assertTrue(save);
        Assert.assertTrue(update);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteEmployee);
        Assert.assertTrue(deleteCustomer);
    }

    public void testDelete() throws Exception {
        //given
        customer.setId(2);
        customer.setFirstName("Cool");
        customer.setLastName("Sergei");
        customer.setAge(new java.sql.Date(2017, 12, 30));
        customer.setPhone(5555555);
        customer.setCity("City");
        customer.setAddress("Address");
        customer.setEmail("Cool@mail.com");
        customer.setPassword("12345");

        employee.setName("Steve");
        employee.setPassword("pass321");

        inputValue.setOrderId(2);
        inputValue.setCustomerCustomerId(2);
        inputValue.setEmployeeEmployeeName("Steve");
        inputValue.setOrderDate(new java.sql.Date(2010, 06, 30));
        inputValue.setShipDate(new java.sql.Date(2019, 10, 30));
        inputValue.setPaymentMethod("ship");
        inputValue.setDelivery("delivery");
        inputValue.setShipFirstName("Fname");
        inputValue.setShipLastName("Lname");
        inputValue.setShipPhone(5555555);
        inputValue.setShipCity("city");
        inputValue.setShipAddress("address");
        inputValue.setShipEmail("mail");

        //when
        boolean saveCustomer = customerDAO.save(customer);
        boolean saveEmployee = employeeDAO.save(employee);
        boolean save = orderDAO.save(inputValue);
        boolean delete = orderDAO.delete(2);
        boolean deleteEmployee = employeeDAO.delete("Steve");
        boolean deleteCustomer = customerDAO.delete(2);

        //then
        Assert.assertTrue(saveCustomer);
        Assert.assertTrue(saveEmployee);
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteEmployee);
        Assert.assertTrue(deleteCustomer);
    }
}