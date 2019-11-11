package datasource; 

import java.util.ArrayList;
import model.Pizza;

/**
 *
 * @author FrederikDahl 
 */
public interface DataSource {
    
    public ArrayList<Pizza> getPizzas();
    public void insertPizza(Pizza pizza);
}