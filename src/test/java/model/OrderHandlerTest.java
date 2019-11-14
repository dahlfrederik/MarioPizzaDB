/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josef
 */
public class OrderHandlerTest {
    
    public OrderHandlerTest() {
    }

    /**
     * Test of makeOrder method, of class OrderHandler.
     */
    @Test
    public void testMakeOrder() {
        //Arrange
        System.out.println("makeOrder");
        ArrayList<Pizza> pizzas = new ArrayList();
        Pizza pizza = new Pizza(2,"Margarita",65);
        Pizza pizza2 = new Pizza(2,"Margarita", 65);
        pizzas.add(pizza);
        OrderHandler oh = new OrderHandler();
        
        //Act
        oh.makeOrder(pizzas);
        ArrayList<Order> orderlist = oh.getOrders();
        
        //Assert
        assertEquals(1, orderlist.size());
        Order order = orderlist.get(0);
        ArrayList<Pizza> pizzalist = order.getPizzas();
        Pizza testPizza = pizzalist.get(0);
        assertEquals(pizza2.getPizzaName(),testPizza.getPizzaName());
        
        
        
        
        



    }

    
    
}
