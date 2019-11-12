

package model;

import java.util.ArrayList;
/**
 *
 * @author FrederikDahl
 */
public class OrderHandler {

    private final ArrayList<Order> orders = new ArrayList();
    
  
    public void makeOrder(ArrayList<Pizza> pizzas) {
        Order order = new Order(1,pizzas); 
        orders.add(order);
    }

      public ArrayList<Order> getOrders() {
       return orders;
    }    
      
      

}


