package datasource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Order;
import model.Pizza;

/**
 *
 * @author FrederikDahl
 */
public class FileHandler implements DataSource {
     ArrayList<Pizza> pizzas = new ArrayList();
    //TODO: Lave menu.txt fil: med nr, navn og pris 
    private static final String FILE_NAME = "menu.txt";

    @Override
    public ArrayList<Pizza> getPizzas() {
        Pizza pizza;
        String[] tmp;
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNext()) {
                tmp = scanner.nextLine().split(" ");
                int nr = Integer.parseInt(tmp[0]);
                String navn = tmp[1]; 
                int price = Integer.parseInt(tmp[2]);
                pizza = new Pizza(nr, navn, price);
                pizzas.add(pizza);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Kunne ikke læse menu fra filen " + FILE_NAME);
        }
        return pizzas;
    }
    
    @Override
    public void insertPizza(Pizza pizza) {
        //Skal være her grundet interface 
        //Er her kun for at kunne implementeres senere
    }
    
    //TODO: INDSÆT TING I DEN 
    public void writeOrder(){
        BufferedWriter bw = null;
        try {
            File pizzaliste = new File("Ordreliste.txt");
            bw = new BufferedWriter(new FileWriter(pizzaliste, true));
            bw.write(toString());
            bw.newLine();   

        } catch (IOException ex) {
            System.out.println("FIL IKKE FUNDET");
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                System.out.println("BUFFEREDWRITER IKKE LUKKET");
            }
        }
    }
    
    public static void main(String[] args) {
        FileHandler fh = new FileHandler(); 
        fh.writeOrder();
    }
 }



