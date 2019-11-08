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

    public ArrayList<Pizza> getMenuKort() {
        ArrayList<Pizza> menukort = new ArrayList();

        try {
            Connection con = DatabaseConnector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pizza.pizzaer");

            while (rs.next()) {
                int nr = rs.getInt("nr");
                String type = rs.getString("type");
                int pris = rs.getInt("pris");
                Pizza pizza = new Pizza(nr, type, pris);
                menukort.add(pizza);
            }
            System.out.println(menukort);
        } catch (SQLException ex) {
            System.out.println("Fejl, pizzaer blev ikke fundet og tilføjet til menukort");
        }
        return menukort;
    }

    public Pizza searchSpecificPizza(String pizzaNavn) {
        Pizza pizza = null;
        try {
            Connection con = DatabaseConnector.getConnection();
            String SQL = "SELECT * FROM pizza.pizzaer WHERE type = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, pizzaNavn);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int nr = rs.getInt("nr");
                String type = rs.getString("type");
                int pris = rs.getInt("pris");
                pizza = new Pizza(nr, type, pris);

            }
        } catch (SQLException ex) {
            System.out.println("Fejl, pizza blev ikke fundet");
        }
        return pizza;
    }
}
