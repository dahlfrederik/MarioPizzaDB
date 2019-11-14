/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.util.ArrayList;
import model.Customer;
import model.Order;
import model.OrderHandler;
import model.Pizza;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author josef
 */
public class OrderMapperTest {

    private OrderMapper om;
    private PizzaMapper pm;

    public OrderMapperTest() {
    }

    @Before
    public void setup() {
        om = new OrderMapper();
        pm = new PizzaMapper();
    }

    /**
     * Test of insertOrders method, of class OrderMapper.
     */
    @Test
    public void testInsertOrders() {
        //Arrange
        System.out.println("insertOrders");
        int oid = 6;
        PizzaMapper pm = new PizzaMapper();
        ArrayList<Pizza> pizzas = pm.getPizzas();
        Customer customer = new Customer("Kongen", 45883023);
        Order order = new Order(oid, pizzas);
        OrderMapper om = new OrderMapper();
        om.insertOrders(order, customer, pizzas);

        //Act
        int result = order.getOrderId();
        int exp = 6;

        //Assert
        assertEquals(exp, result);

    }

    @Test
    
    // DATABASEN SKAL RYDDES INDEN TEST
    public void testCountOrders() {
        
        //Arrange
        int oid = 6;
        PizzaMapper pm = new PizzaMapper();
        ArrayList<Pizza> pizzas = pm.getPizzas();
        Order order = new Order(oid, pizzas);
        OrderMapper om = new OrderMapper();
        Customer cus = new Customer("Kim", 21332281);
        om.insertOrders(order, cus, pizzas);
        
        
        //Act
        int result = om.countOrders();
        int exp = 1;
        
        //Assert
        assertEquals(exp, result);
        
      

    }

}
