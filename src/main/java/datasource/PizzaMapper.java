

package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pizza; 
import model.MenuKort; 


public class PizzaMapper {
   
    public ArrayList<Pizza> getPizzas(){
         MenuKort menukort = new MenuKort(); 
       
        try {
            Connection con = new DatabaseConnector().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pizza.pizzaer");
            
            while (rs.next()) {
                int nr = rs.getInt("nr");
                String type = rs.getString("type");
                int pris = rs.getInt("pris");
                Pizza pizza = new Pizza(nr, type, pris); 
                menukort.addPizza(pizza);
                System.out.println(menukort);
            } 
        } catch (SQLException ex) {
            System.out.println("Fejl, pizzaer blev ikke fundet og tilføjet til menukort");
        }
        return menukort.getMenuKort(); 
    }
    
    public static void main(String[] args) {
        new PizzaMapper().getPizzas(); 
    }
}
