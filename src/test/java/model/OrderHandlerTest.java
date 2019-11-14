package model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Frederik, Hallur, Josef og Thor
 */
public class OrderHandlerTest {

    public OrderHandlerTest() {
    }

    @Test
    public void testMakeOrder() {
        //Arrange
        ArrayList<Pizza> pizzas = new ArrayList();
        Pizza pizza = new Pizza(2, "Margarita", 65);
        Pizza pizza2 = new Pizza(2, "Margarita", 65);
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
        assertEquals(pizza2.getPizzaName(), testPizza.getPizzaName());

    }

}
