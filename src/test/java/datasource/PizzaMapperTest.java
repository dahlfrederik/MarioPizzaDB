/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.util.ArrayList;
import model.Order;
import model.Pizza;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FrederikDahl
 */
public class PizzaMapperTest {

    public PizzaMapperTest() {
    }

    @Test
    public void testSearchSpecificPizza() {
        Pizza expPizza = new Pizza(14, "Gollum", 25);
        String exp = expPizza.getPizzaName();
        Pizza resultPizza = new PizzaMapper().searchSpecificPizza("Gollum");
        String result = "Gollum";
        System.out.println(resultPizza);
        System.out.println(expPizza);

        assertEquals(exp, result);
        //assertEquals(expPizza, resultPizza); 
    }

    /**
     * Test of getPizzas method, of class PizzaMapper.
     */
    @Test
    public void testGetPizzas() {

        //Arrange
        int oid = 6;
        PizzaMapper pm = new PizzaMapper();
        ArrayList<Pizza> pizzas = pm.getPizzas();
        Order order = new Order(oid, pizzas);
        OrderMapper om = new OrderMapper();

        //Act
        int result = om.countOrders();
        int exp = 11;

        //Assert
        assertEquals(exp, result);

    }

   
}
