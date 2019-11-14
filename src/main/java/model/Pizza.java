package model;

/**
 * @author Josef, Thor, Hallur og Frederik 
 */

public class Pizza {
    private int pizzaNr, pizzaPrice, qty; 
    private String pizzaName; 

    public Pizza(int pizzaNr, String pizzaName, int pizzaPrice) {
        this.pizzaNr = pizzaNr;
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
    }
    
    public Pizza(int pizzaNr, int qty){
        this.pizzaNr = pizzaNr; 
        this.qty = qty; 
    }

    public int getPizzaNr() {
        return pizzaNr;
    }

    public void setPizzaNr(int pizzaNr) {
        this.pizzaNr = pizzaNr;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public int getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(int pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }
    
    public void setQty(int qty){
        this.qty = qty; 
    }
    
    public int getQty(){
        return qty; 
    }
    
    @Override
    public String toString() {
        return "Nr: "+ pizzaNr + ", pizza med " + pizzaName + ", pris: " + pizzaPrice  + "  antal pizzaer: " + qty + "\n"; 
    }
}
