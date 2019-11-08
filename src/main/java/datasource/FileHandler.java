package datasource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Pizza;

/**
 *
 * @author FrederikDahl
 */
public class FileHandler implements DataSource {
    //TODO: Lave menu.txt fil: med nr, navn og pris 
    private static final String FILE_NAME = "menu.txt";

    @Override
    public ArrayList<Pizza> getPizzas() {
        ArrayList<Pizza> pizzas = new ArrayList();
        Pizza pizza;
        String[] tmp;
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNext()) {
                tmp = scanner.nextLine().split(" ");
                int id = Integer.parseInt(tmp[0]);
                String navn = tmp[1]; 
                int price = Integer.parseInt(tmp[2]);
                pizza = new Pizza(id, navn, price);
                pizzas.add(pizza);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Kunne ikke læse menu fra filen " + FILE_NAME);
        }
        return pizzas;
    }

    //TODO 
    @Override
    public void insertPizza(Pizza pizza) {
    }
}


