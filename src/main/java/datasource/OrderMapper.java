package datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Kunde;
import model.Order;
import model.OrdreListe;

/**
 * @author Josef, Thor, Hallur og Frederik 
 */
 
public class OrderMapper {
    
    //Bestillinger 
    public ArrayList<Order> getOrders(){
    OrdreListe orderlist = new OrdreListe(); 
        try {
            Connection con = DatabaseConnector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pizza.orders");

            while (rs.next()) {
                int tidTilAfhentning = rs.getInt("tidTilAfhentning");
                String kundeNavn = rs.getString("navn");
                int kundeNr = rs.getInt("nr");
                Kunde kunde = new Kunde(kundeNavn, kundeNr); 
                Order order = new Order(kunde, tidTilAfhentning); 
                orderlist.tilføjOrdrer(order);
            }
            
            System.out.println(orderlist);
        } catch (SQLException ex) {
            System.out.println("Fejl, ordre blev ikke tilføjet til listen");
        }
        return orderlist.getOrderListe();
    }
    
}
