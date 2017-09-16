package main.java.com.kuleshov.dao;

import com.kuleshov.dao.OrderDAO;
import com.kuleshov.dao.UserDAO;
import com.kuleshov.entity.User;
import com.kuleshov.entity.Order;
import org.junit.Assert;
import org.junit.Test;

public class OrderDAOTest {

    private UserDAO userDAO = new UserDAO();
    private User user = new User();

    private OrderDAO orderDAO = new OrderDAO();
    private Order inputValue = new Order();
    private Order updateValue = new Order();

    @Test
    public void shouldSaveOrder() {

        //given
        user.setId(1);
        user.setFirstName("Cool");
        user.setLastName("Sergei");
        user.setAge(new java.sql.Date(2017, 12, 30));
        user.setPhone(5555555);
        user.setCity("City");
        user.setAddress("Address");
        user.setEmail("Cool@mail.com");
        user.setPassword("12345");

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
        boolean saveCustomer = userDAO.save(user);
        boolean save = orderDAO.save(inputValue);
        boolean delete = orderDAO.delete(1);
        boolean deleteCustomer = userDAO.delete(1);

        //then
        Assert.assertTrue(saveCustomer);
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteCustomer);
    }

    @Test
    public void shouldFindOrder() {
        
        //given
        user.setId(3);
        user.setFirstName("Cool");
        user.setLastName("Sergei");
        user.setAge(new java.sql.Date(2017, 12, 30));
        user.setPhone(5555555);
        user.setCity("City");
        user.setAddress("Address");
        user.setEmail("Cool@mail.com");
        user.setPassword("12345");

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
        boolean saveCustomer = userDAO.save(user);
        boolean save = orderDAO.save(inputValue);
        Order find = orderDAO.find(3);
        boolean delete = orderDAO.delete(3);
        boolean deleteCustomer = userDAO.delete(3);

        //then
        Assert.assertTrue(saveCustomer);
        Assert.assertTrue(save);
        Assert.assertEquals(inputValue, find);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteCustomer);
    }

    @Test
    public void shouldUpdateOrder() {

        //given
        user.setId(4);
        user.setFirstName("Cool");
        user.setLastName("Sergei");
        user.setAge(new java.sql.Date(2017, 12, 30));
        user.setPhone(5555555);
        user.setCity("City");
        user.setAddress("Address");
        user.setEmail("Cool@mail.com");
        user.setPassword("12345");

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
        boolean saveCustomer = userDAO.save(user);
        boolean save = orderDAO.save(inputValue);
        boolean update = orderDAO.update(updateValue);
        boolean delete = orderDAO.delete(4);
        boolean deleteCustomer = userDAO.delete(4);

        //then
        Assert.assertTrue(saveCustomer);
        Assert.assertTrue(save);
        Assert.assertTrue(update);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteCustomer);
    }

    @Test
    public void shouldDeleteOrder() {

        //given
        user.setId(2);
        user.setFirstName("Cool");
        user.setLastName("Sergei");
        user.setAge(new java.sql.Date(2017, 12, 30));
        user.setPhone(5555555);
        user.setCity("City");
        user.setAddress("Address");
        user.setEmail("Cool@mail.com");
        user.setPassword("12345");

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
        boolean saveCustomer = userDAO.save(user);
        boolean save = orderDAO.save(inputValue);
        boolean delete = orderDAO.delete(2);
        boolean deleteCustomer = userDAO.delete(2);

        //then
        Assert.assertTrue(saveCustomer);
        Assert.assertTrue(save);
        Assert.assertTrue(delete);
        Assert.assertTrue(deleteCustomer);
    }
}