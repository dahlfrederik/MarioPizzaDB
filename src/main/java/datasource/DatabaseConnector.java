package datasource;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Josef, Thor, Hallur og Frederik 
 * Lavet ud fra singleton princippet: Derfor er connection statisk. 
 */
public class DatabaseConnector {

    //private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/pizza";
    private static final String USER = "root";
    private static final String PASSWORD = "green8house17";
    private static Connection con;
    
    private DatabaseConnector(){
        
    }

    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }

}
