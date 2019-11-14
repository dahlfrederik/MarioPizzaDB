package datasource;

import model.Pizza;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Frederik, Hallur, Josef og Thor
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
    }

}
