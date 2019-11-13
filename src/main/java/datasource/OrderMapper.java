package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Order;
import model.Pizza;

/**
 * @author Josef, Thor, Hallur og Frederik
 */
public class OrderMapper {

    private Connection con = DatabaseConnector.getConnection();
    private Statement stmt;
    private Order order; 
    private PizzaMapper pm = new PizzaMapper(); 

    //Bestillinger 
    public ArrayList<Order> getOrders(){
        ArrayList<Order> orderlist = new ArrayList(); 
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
                orderlist.add(order);
            }
            
            System.out.println(orderlist);
        } catch (SQLException ex) {
            System.out.println("Fejl, ordre blev ikke tilføjet til listen");
        }
        return orderlist; 
    }
  
    public void insertOrders(Order order, Customer customer) {
        try {
            //Indsætter i orders 
            String SQL = "INSERT INTO orders (oid, date, tele) VALUES (?,?,?)";
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order.getOrderId()); 
            LocalDateTime now = LocalDateTime.now();
            Timestamp sqlNow = Timestamp.valueOf(now);
            ps.setTimestamp(2,sqlNow); 
            ps.setInt(3, customer.getTele()); 
            ps.executeUpdate(); 
                      
            //Indsætter i odedetails 
            ArrayList<Pizza> pizzas = pm.getPizzas();
            String SQL2 =  "INSERT INTO odetails (oid, nr, qty) VALUES (?, ?, ?)";
            for (Pizza pizza : pizzas) {
                PreparedStatement ps2 = con.prepareStatement(SQL2); 
                   ps2.setInt(1,order.getOrderId()); 
                   ps2.setInt(2,pizza.getPizzaNr()); 
                   ps2.setInt(3,pizza.getQty()); 
                   ps2.executeUpdate(); 
            }
          
        } catch (SQLException ex) {
            System.out.println("FEJL! Kunne ikke indsætte ordre i databasen");
        
        }
    }

       
      public static void main(String[] args)  {
        PizzaMapper pm = new PizzaMapper(); 
        ArrayList<Pizza> pizzas = pm.getPizzas(); 
        Customer customer = new Customer("Hejf", 45883023);
        Order order = new Order(6, pizzas);
        OrderMapper om = new OrderMapper();
        om.insertOrders(order, customer);
        
    }
    
    public int countOrders(){
        int count = 0; 
        try {
            String SQL = "SELECT COUNT(*) FROM orders";
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                count = rs.getInt(1);
             }
        } catch (SQLException ex) {
            System.out.println("Antal ordre blev ikke talt");
        }
        return count; 
        
    }

  

}
