package model;

/**
 * @author Josef, Thor, Hallur og Frederik 
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MenuKort {

    // indeholde "pizzaer"
    private ArrayList<Pizza> menukort = new ArrayList<Pizza>();
    
    public MenuKort(){
        
    }

    public void addPizza(Pizza pizza) {
        menukort.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        menukort.remove(pizza);
    }
    
    public ArrayList getMenuKort(){
        return menukort; 
    }
    
    public void lavMenuKort(){
        BufferedWriter bw = null;
        try { 
            File menukortfil = new File("Menukort.txt");
            bw = new BufferedWriter(new FileWriter(menukortfil)); 
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

    @Override
    public String toString() {
        String totalMenu = "";
        totalMenu += "MENUKORT" + "\n"; 
        totalMenu += "*****************" + "\n"; 

        for (Pizza total : menukort) {
            totalMenu += "\n"; 
            totalMenu += total.toString() + "\n";
            
        }
        
        return totalMenu;
    }
    
    
}
