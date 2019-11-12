package model;

import java.util.ArrayList;

/**
 * @author Frederik, Hallur, Josef og Thor
 */
public class Order {

    private int orderId;  
    private ArrayList<Pizza> pizzas = new ArrayList(); 

    public Order(int orderId, ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
        this.orderId = orderId; 
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
    
    public int getTotalPrice(){
        int totalPrice = 0;
        for (Pizza pizza : pizzas) {
            totalPrice += pizza.getPizzaPrice();
        }
        return totalPrice; 
    }

    @Override
    public String toString() {
        return "Ordre Nr:   " + orderId
                /*+ "\nAfhentningstidspunkt:\t" + afhentningsTidspunkt */
                + "\nOrdre beskrivelse:\n\t" + pizzas;
    }
    
}

