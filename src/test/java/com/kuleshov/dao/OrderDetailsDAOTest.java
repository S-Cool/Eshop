package com.kuleshov.dao;

import com.kuleshov.entity.*;
import org.junit.Assert;
import org.junit.Test;

public class OrderDetailsDAOTest {

    private CustomerDAO customerDAO = new CustomerDAO();
    private Customer customer = new Customer();

    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private Employee employee = new Employee();

    private OrderDAO orderDAO = new OrderDAO();
    private Order order = new Order();

    private CategoryDAO categoryDAO = new CategoryDAO();
    private Category category = new Category();

    private ProductDAO productDAO = new ProductDAO();
    private Product product = new Product();

    private OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
    private OrderDetails inputValue = new OrderDetails();
    private OrderDetails updateValue = new OrderDetails();


    @Test
    public void shouldSaveOrderDetails() {
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

        order.setOrderId(1);
        order.setCustomerCustomerId(1);
        order.setEmployeeEmployeeName("Peter");
        order.setOrderDate(new java.sql.Date(2010, 06, 30));
        order.setShipDate(new java.sql.Date(2019, 10, 30));
        order.setPaymentMethod("ship");
        order.setDelivery("delivery");
        order.setShipFirstName("Fname");
        order.setShipLastName("Lname");
        order.setShipPhone(5555555);
        order.setShipCity("city");
        order.setShipAddress("address");
        order.setShipEmail("mail");

        category.setCategoryId(4);
        category.setCategoryName("Tech");
        category.setCategoryDescription("Tech description");

        product.setProductId("id123");
        product.setProductName("name");
        product.setQuantityInStock(999);
        product.setPrice(499);
        product.setDescription("desc prod");
        product.setBrand("brand");
        product.setCategoryCategoryId(4);

        inputValue.setOrderDetailsId(1);
        inputValue.setProductId("id1234");
        inputValue.setOrderId(1);
        inputValue.setUnitPrice(50);
        inputValue.setQuantity(2);
        inputValue.setDiscount(0);

        //when
        boolean saveCustomer = customerDAO.save(customer);
        boolean saveEmployee = employeeDAO.save(employee);
        boolean saveCategory = categoryDAO.save(category);
        boolean saveOrder = orderDAO.save(order);
        boolean saveProduct = productDAO.save(product);
        boolean save = orderDetailsDAO.save(inputValue);
        OrderDetails find = orderDetailsDAO.find(1);
        boolean delete = orderDetailsDAO.delete(1);
        boolean deleteProduct = productDAO.delete("id123");
        boolean deleteOrder = orderDAO.delete(1);
        boolean deleteCategory = categoryDAO.delete("Tech");
        boolean deleteEmployee = employeeDAO.delete("Peter");
        boolean deleteCustomer = customerDAO.delete(1);

        //then
        Assert.assertTrue(saveCustomer);
        Assert.assertTrue(saveEmployee);
        Assert.assertTrue(saveOrder);
        Assert.assertTrue(saveCategory);
        Assert.assertTrue(saveProduct);
        Assert.assertTrue(save);
        Assert.assertEquals(find,inputValue);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteEmployee);
        Assert.assertTrue(deleteCustomer);
        Assert.assertTrue(deleteProduct);
        Assert.assertTrue(deleteOrder);
        Assert.assertTrue(deleteCategory);
    }

    @Test
    public void shouldFindOrderDetails() {
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

        order.setOrderId(1);
        order.setCustomerCustomerId(1);
        order.setEmployeeEmployeeName("Peter");
        order.setOrderDate(new java.sql.Date(2010, 06, 30));
        order.setShipDate(new java.sql.Date(2019, 10, 30));
        order.setPaymentMethod("ship");
        order.setDelivery("delivery");
        order.setShipFirstName("Fname");
        order.setShipLastName("Lname");
        order.setShipPhone(5555555);
        order.setShipCity("city");
        order.setShipAddress("address");
        order.setShipEmail("mail");

        category.setCategoryId(4);
        category.setCategoryName("Tech");
        category.setCategoryDescription("Tech description");

        product.setProductId("id123");
        product.setProductName("name");
        product.setQuantityInStock(999);
        product.setPrice(499);
        product.setDescription("desc prod");
        product.setBrand("brand");
        product.setCategoryCategoryId(4);

        inputValue.setOrderDetailsId(1);
        inputValue.setProductId("id1234");
        inputValue.setOrderId(1);
        inputValue.setUnitPrice(50);
        inputValue.setQuantity(2);
        inputValue.setDiscount(0);

        updateValue.setOrderDetailsId(1);
        updateValue.setProductId("id1234");
        updateValue.setOrderId(1);
        updateValue.setUnitPrice(100);
        updateValue.setQuantity(3);
        updateValue.setDiscount(30);

        //when
        boolean saveCustomer = customerDAO.save(customer);
        boolean saveEmployee = employeeDAO.save(employee);
        boolean saveCategory = categoryDAO.save(category);
        boolean saveOrder = orderDAO.save(order);
        boolean saveProduct = productDAO.save(product);
        boolean save = orderDetailsDAO.save(inputValue);
        OrderDetails find = orderDetailsDAO.find(1);
        boolean update = orderDetailsDAO.update(updateValue);
        boolean delete = orderDetailsDAO.delete(1);
        boolean deleteProduct = productDAO.delete("id123");
        boolean deleteOrder = orderDAO.delete(1);
        boolean deleteCategory = categoryDAO.delete("Tech");
        boolean deleteEmployee = employeeDAO.delete("Peter");
        boolean deleteCustomer = customerDAO.delete(1);

        //then
        Assert.assertTrue(saveCustomer);
        Assert.assertTrue(saveEmployee);
        Assert.assertTrue(saveOrder);
        Assert.assertTrue(saveCategory);
        Assert.assertTrue(saveProduct);
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(update);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteEmployee);
        Assert.assertTrue(deleteCustomer);
        Assert.assertTrue(deleteProduct);
        Assert.assertTrue(deleteOrder);
        Assert.assertTrue(deleteCategory);
    }

    @Test
    public void shouldUpdateOrderDetails() {
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

        order.setOrderId(1);
        order.setCustomerCustomerId(1);
        order.setEmployeeEmployeeName("Peter");
        order.setOrderDate(new java.sql.Date(2010, 06, 30));
        order.setShipDate(new java.sql.Date(2019, 10, 30));
        order.setPaymentMethod("ship");
        order.setDelivery("delivery");
        order.setShipFirstName("Fname");
        order.setShipLastName("Lname");
        order.setShipPhone(5555555);
        order.setShipCity("city");
        order.setShipAddress("address");
        order.setShipEmail("mail");

        category.setCategoryId(4);
        category.setCategoryName("Tech");
        category.setCategoryDescription("Tech description");

        product.setProductId("id123");
        product.setProductName("name");
        product.setQuantityInStock(999);
        product.setPrice(499);
        product.setDescription("desc prod");
        product.setBrand("brand");
        product.setCategoryCategoryId(4);

        inputValue.setOrderDetailsId(1);
        inputValue.setProductId("id1234");
        inputValue.setOrderId(1);
        inputValue.setUnitPrice(50);
        inputValue.setQuantity(2);
        inputValue.setDiscount(0);

        updateValue.setOrderDetailsId(1);
        updateValue.setProductId("id1234");
        updateValue.setOrderId(1);
        updateValue.setUnitPrice(100);
        updateValue.setQuantity(3);
        updateValue.setDiscount(30);

        //when
        boolean saveCustomer = customerDAO.save(customer);
        boolean saveEmployee = employeeDAO.save(employee);
        boolean saveCategory = categoryDAO.save(category);
        boolean saveOrder = orderDAO.save(order);
        boolean saveProduct = productDAO.save(product);
        boolean save = orderDetailsDAO.save(inputValue);
        boolean update = orderDetailsDAO.update(updateValue);
        OrderDetails find = orderDetailsDAO.find(1);
        boolean delete = orderDetailsDAO.delete(1);
        boolean deleteProduct = productDAO.delete("id123");
        boolean deleteOrder = orderDAO.delete(1);
        boolean deleteCategory = categoryDAO.delete("Tech");
        boolean deleteEmployee = employeeDAO.delete("Peter");
        boolean deleteCustomer = customerDAO.delete(1);

        //then
        Assert.assertTrue(saveCustomer);
        Assert.assertTrue(saveEmployee);
        Assert.assertTrue(saveOrder);
        Assert.assertTrue(saveCategory);
        Assert.assertTrue(saveProduct);
        Assert.assertTrue(save);
        Assert.assertTrue(update);
        Assert.assertEquals(updateValue, find);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteEmployee);
        Assert.assertTrue(deleteCustomer);
        Assert.assertTrue(deleteProduct);
        Assert.assertTrue(deleteOrder);
        Assert.assertTrue(deleteCategory);
    }

    @Test
    public void shouldDeleteOrderDetails() {
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

        order.setOrderId(1);
        order.setCustomerCustomerId(1);
        order.setEmployeeEmployeeName("Peter");
        order.setOrderDate(new java.sql.Date(2010, 06, 30));
        order.setShipDate(new java.sql.Date(2019, 10, 30));
        order.setPaymentMethod("ship");
        order.setDelivery("delivery");
        order.setShipFirstName("Fname");
        order.setShipLastName("Lname");
        order.setShipPhone(5555555);
        order.setShipCity("city");
        order.setShipAddress("address");
        order.setShipEmail("mail");

        category.setCategoryId(4);
        category.setCategoryName("Tech");
        category.setCategoryDescription("Tech description");

        product.setProductId("id123");
        product.setProductName("name");
        product.setQuantityInStock(999);
        product.setPrice(499);
        product.setDescription("desc prod");
        product.setBrand("brand");
        product.setCategoryCategoryId(4);

        inputValue.setOrderDetailsId(1);
        inputValue.setProductId("id1234");
        inputValue.setOrderId(1);
        inputValue.setUnitPrice(50);
        inputValue.setQuantity(2);
        inputValue.setDiscount(0);

        //when
        boolean saveCustomer = customerDAO.save(customer);
        boolean saveEmployee = employeeDAO.save(employee);
        boolean saveCategory = categoryDAO.save(category);
        boolean saveOrder = orderDAO.save(order);
        boolean saveProduct = productDAO.save(product);
        boolean save = orderDetailsDAO.save(inputValue);
        boolean delete = orderDetailsDAO.delete(1);
        OrderDetails findAfterDelete = orderDetailsDAO.find(1);
        boolean deleteProduct = productDAO.delete("id123");
        boolean deleteOrder = orderDAO.delete(1);
        boolean deleteCategory = categoryDAO.delete("Tech");
        boolean deleteEmployee = employeeDAO.delete("Peter");
        boolean deleteCustomer = customerDAO.delete(1);

        //then
        Assert.assertTrue(saveCustomer);
        Assert.assertTrue(saveEmployee);
        Assert.assertTrue(saveOrder);
        Assert.assertTrue(saveCategory);
        Assert.assertTrue(saveProduct);
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
        Assert.assertNotEquals(inputValue, findAfterDelete);
        Assert.assertTrue(deleteEmployee);
        Assert.assertTrue(deleteCustomer);
        Assert.assertTrue(deleteProduct);
        Assert.assertTrue(deleteOrder);
        Assert.assertTrue(deleteCategory);
    }
}
