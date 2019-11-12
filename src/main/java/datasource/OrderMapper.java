package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
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
          
            }
        } catch (SQLException ex) {
            System.out.println("Fejl, order blev ikke fundet");
        }
        return order;
    }
    public void insertOrders(Order order, Customer customer) {
        try {
            String SQL = "INSERT INTO orders (oid, date, nr, tele) VALUES (?,?,?,?)";
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order.getOrderId()); 
            LocalTime tid = LocalTime.now(); 
            Time convTime = java.sql.Time.valueOf(tid);; 
            ps.setTime(2,convTime); 
            ps.setInt(3, order.getPizzas().get(0).getPizzaNr());
            ps.setInt(4, customer.getTele()); 
            ps.executeUpdate(); 
             
            //TODO: Debugging tool
            System.out.println(order + ": med dataene, orderId " + order.getOrderId() + 
                    " tid: " + convTime + " pizzanr: " + order.getPizzas().get(0).getPizzaNr() + " tele: " + customer.getTele() + 
                    "er tilføjet til Databasen");

        } catch (SQLException ex) {
            System.out.println("FEJL! Kunne ikke indsætte ordre i databasen");
        } 
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

    public static void main(String[] args)  {
        PizzaMapper pm = new PizzaMapper(); 
        ArrayList<Pizza> pizzas = pm.getPizzas(); 
        Customer customer = new Customer("Thorsc", 45883023);
        Order order = new Order(7, pizzas);
        OrderMapper om = new OrderMapper();
        om.insertOrders(order, customer);
        om.countOrders();
    }

}
