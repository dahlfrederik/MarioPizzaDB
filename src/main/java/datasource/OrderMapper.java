package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                int id = rs.getInt("id");
                int nr = rs.getInt("nr");
                int tele = rs.getInt("tele"); 
                Order order = new Order(id, nr, tele); 
                orderlist.tilføjOrdrer(order);
            }
            
            System.out.println(orderlist);
        } catch (SQLException ex) {
            System.out.println("Fejl, ordre blev ikke tilføjet til listen");
        }
        return orderlist.getOrderListe();
    }
    
    public Order searchSpecificOrdre(int ordreId) {
        Order order = null;
        try {
            Connection con = DatabaseConnector.getConnection();
            String SQL = "SELECT * FROM mariopizzaria.orders WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, ordreId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                int nr = rs.getInt("nr");
                int tele = rs.getInt("tele");
                order = new Order(id, nr, tele);

            }
        } catch (SQLException ex) {
            System.out.println("Fejl, order blev ikke fundet");
        }
        return order;
    }
    
    
    
    
}
