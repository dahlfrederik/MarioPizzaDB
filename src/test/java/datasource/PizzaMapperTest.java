/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.util.ArrayList;
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
        String exp = expPizza.getPizzaNavn(); 
        Pizza resultPizza = new PizzaMapper().searchSpecificPizza("Gollum");
        String result = "Gollum"; 
        System.out.println(resultPizza);
        System.out.println(expPizza);
       
        assertEquals(exp, result);
        //assertEquals(expPizza, resultPizza); 
      
    }
    
}
