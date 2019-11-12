package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
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
                int id = rs.getInt("oid");
                int nr = rs.getInt("nr");
                int tele = rs.getInt("tele"); 
                Time time = rs.getTime("date"); 
                LocalTime convTime = time.toLocalTime(); 
                Order order = new Order(id, nr, tele, convTime); 
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
                int id = rs.getInt("oid");
                int nr = rs.getInt("nr");
                int tele = rs.getInt("tele");
                Time time = rs.getTime("date"); 
                LocalTime convTime = time.toLocalTime(); 
                order = new Order(id, nr, tele, convTime);

            }
        } catch (SQLException ex) {
            System.out.println("Fejl, order blev ikke fundet");
        }
        return order;
    }
    
    public void insertOrders(Order order){
        try {
            //String SQL = "INSERT INTO odetails (oid, nr, qty) VALUES (?, ?, ?)";
           String SQL2 = "INSERT INTO orders (oid, date, nr, tele) VALUES (?,?,?,?)"; 
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL2);
//            ps.setInt(1, order.getOrderNr());
//            ps.setInt(2, order.getPizzaNr());
//            ps.setInt(3, order.getQty());
              LocalTime tid = LocalTime.now(); 
              Time convTime = java.sql.Time.valueOf(tid);; 
              ps.setInt(1,1);
              ps.setTime(2,convTime);
              ps.setInt(3, 2);
              ps.setInt(4, 5);
              
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println("FEJL! Kunne ikke indsætte ordre i databasen");
        }
    }
    
    public static void main(String[] args) {
        OrderMapper om = new OrderMapper(); 
        LocalTime tid = LocalTime.now(); 
        Order order = new Order(3,5,1,tid); 
        om.insertOrders(order); 
    }
    
    
}
