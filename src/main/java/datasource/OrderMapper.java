package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import model.Customer;
import model.Order;
import model.Pizza;

/**
 * @author Josef, Thor, Hallur og Frederik 
 */
 
public class OrderMapper {
    private Customer customer; 
    private Pizza pizza; 
    private Connection con = DatabaseConnector.getConnection();
    private Statement stmt; 
    
    //Bestillinger 
//    public ArrayList<Order> getOrders(){
//        ArrayList<Order> orderlist = new ArrayList(); 
//        try {
//            con = DatabaseConnector.getConnection();
//            stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM mariopizzaria.orders");
//
//            while (rs.next()) {
//                int id = rs.getInt("oid");
//                int nr = rs.getInt("nr");
//                int tele = rs.getInt("tele"); 
//                Time time = rs.getTime("date"); 
//                LocalTime convTime = time.toLocalTime(); 
//                
//                orderlist.add(order);
//            }
//            
//            System.out.println(orderlist);
//        } catch (SQLException ex) {
//            System.out.println("Fejl, ordre blev ikke tilføjet til listen");
//        }
//        return orderlist; 
//    }
//    
//    public Order searchSpecificOrdre(int ordreId) {
//        Order order = null;
//        try {
//            con = DatabaseConnector.getConnection();
//            String SQL = "SELECT * FROM mariopizzaria.orders WHERE id = ?";
//            PreparedStatement ps = con.prepareStatement(SQL);
//            ps.setInt(1, ordreId);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                int id = rs.getInt("oid");
//                int nr = rs.getInt("nr");
//                int tele = rs.getInt("tele");
//                Time time = rs.getTime("date"); 
//                LocalTime convTime = time.toLocalTime(); 
//                order = new Order(id, nr, tele, convTime);
//
//            }
//        } catch (SQLException ex) {
//            System.out.println("Fejl, order blev ikke fundet");
//        }
//        return order;
//    }
    
    public void insertOrders(Order order, Pizza pizza, Customer customer){
        try {
            //String SQL = "INSERT INTO odetails (oid, nr, qty) VALUES (?, ?, ?)";
            String SQL2 = "INSERT INTO orders (oid, date, nr, tele) VALUES (?,?,?,?)"; 
            con = DatabaseConnector.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL2);
 
            ps.setInt(1, order.getOrderId()); 
            LocalTime tid = LocalTime.now(); 
            Time convTime = java.sql.Time.valueOf(tid);; 
            ps.setTime(2,convTime); 
            ps.setInt(3, pizza.getPizzaNr());
            ps.setInt(4, customer.getTele()); 
              
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            System.out.println("FEJL! Kunne ikke indsætte ordre i databasen");
        }
    }   
    
    public static void main(String[] args) {
        ArrayList<Pizza> pizzas = new ArrayList(); 
        Customer customer = new Customer("Freddy", 323123123); 
        Pizza pizza = new Pizza(1,"test3",45); 
        pizzas.add(pizza); 
        Order order = new Order(pizzas); 
        OrderMapper om = new OrderMapper(); 
        
        om.insertOrders(order, pizza,customer);
    }
    
    
    
    
}
