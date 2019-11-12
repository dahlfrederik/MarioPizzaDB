package model;

import java.util.ArrayList;

/**
 * @author Frederik, Hallur, Josef og Thor
 */
public class Order {

    private int orderId;  
    private ArrayList<Pizza> pizzas = new ArrayList(); 

    public Order(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }
    
    public void setOrderId(int orderNo) {
        this.orderId = orderNo;
    }
    
    public int getOrderId(){
        return orderId; 
    }

    @Override
    public String toString() {
        return "Ordre Nr:   " + orderId
                /*+ "\nAfhentningstidspunkt:\t" + afhentningsTidspunkt */
                + "\nOrdre beskrivelse:\n\t" + pizzas;
    }
    
}

