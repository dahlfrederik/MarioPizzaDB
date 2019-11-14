package datasource; 

import java.util.ArrayList;
import model.Order;
import model.Pizza;

/**
 * @author Frederik, Hallur, Josef og Thor
 */
public interface DataSource {
    
    public ArrayList<Pizza> getPizzas();
    public void insertPizza(Pizza pizza);
}
