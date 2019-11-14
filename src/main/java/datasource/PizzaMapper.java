package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pizza;

/**
 * @author Josef, Thor, Hallur og Frederik 
 */

public class PizzaMapper {
     private Connection con = DatabaseConnector.getConnection();
     private Statement stmt; 

    //Finder pizza fra menu 
    public ArrayList<Pizza> getPizzas() {
        ArrayList<Pizza> menukort = new ArrayList();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mariopizzaria.pizzas");

            while (rs.next()) {
                int nr = rs.getInt("nr");
                String type = rs.getString("type");
                int pris = rs.getInt("price");
                Pizza pizza = new Pizza(nr, type, pris);
                menukort.add(pizza);
            }
            System.out.println(menukort);
        } catch (SQLException ex) {
            System.out.println("Fejl, pizzaer blev ikke fundet og tilføjet til menukort");
        }
        return menukort;
    }
    
    //Kan finde specifik pizza 
    public Pizza searchSpecificPizza(String pizzaNavn) {
        Pizza pizza = null;
        try {
            Connection con = DatabaseConnector.getConnection();
            String SQL = "SELECT * FROM mariopizzaria.pizzas WHERE type = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, pizzaNavn);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int nr = rs.getInt("nr");
                String type = rs.getString("type");
                int pris = rs.getInt("price");
                pizza = new Pizza(nr, type, pris);
            }
        } catch (SQLException ex) {
            System.out.println("Fejl, pizza blev ikke fundet");
        }
        return pizza;
    }
    
    //Indsætter pizza til databasen 
     public void insertPizza(Pizza pizza) {
        try {
            String SQL = "INSERT INTO pizzas (nr, type, price) VALUES (?, ?, ?)";
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pizza.getPizzaNr());
            ps.setString(2, pizza.getPizzaName());
            ps.setInt(3, pizza.getPizzaPrice());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("FEJL! Kunne ikke indsætte pizza");
        }
    }
}
