package datasource;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FrederikDahl
 */
public class DatabaseConnector {

    //private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/pizza";
    private static final String USER = "root";
    private static final String PASSWORD = "green8house17";

    public void connectToAndQueryDatabase() {
        Connection con = null; 
        Statement stmt = null; 
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM pizza.pizzaer");

            while (rs.next()) {
                int nr = rs.getInt("nr");
                String type = rs.getString("type");
                int pris = rs.getInt("pris");
                System.out.println("Pizza: " + nr + ", " + type + ", " + pris + " kr");
        } 

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try { 
                rs.close();
                con.close();
                stmt.close(); 
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    public static void main(String[] args) {
        new DatabaseConnector().connectToAndQueryDatabase(); 
        
    }
}
