package datasource;

import java.util.ArrayList;
import model.Order;
import model.Pizza;
/**
 * @author FrederikDahl
 */
public class DatabaseHandler implements DataSource {

    private Order order;
    
    @Override
    public ArrayList<Pizza> getPizzas() {
        return new PizzaMapper().getPizzas(); 
    }

    @Override
    public void insertPizza(Pizza pizza) {
        new PizzaMapper().insertPizza(pizza);
    }
}