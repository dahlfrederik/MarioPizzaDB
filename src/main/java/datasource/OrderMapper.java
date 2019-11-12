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
    Connection con = DatabaseConnector.getConnection();
    Statement stmt; 
    
    //Bestillinger 
    public ArrayList<Order> getOrders(){
    OrdreListe orderlist = new OrdreListe(); 
        try {
            con = DatabaseConnector.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mariopizzaria.orders");

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
            con = DatabaseConnector.getConnection();
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
    
    public void insertOrders(){
        try {
            Order order = null; 
            String SQL = "INSERT INTO odetails (pizzaid, orderid, qty) VALUES (?, ?, ?)";
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getOrderNr());
            ps.setInt(2, order.getPizzaNr());
            ps.setInt(3, order.getTele());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("FEJL! Kunne ikke indsætte ordre i databasen");
        }
    }
    
    
    
}
