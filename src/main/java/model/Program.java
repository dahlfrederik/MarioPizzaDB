

package model;

import datasource.DataSource;
import datasource.DatabaseHandler;

/**
 *
 * @author FrederikDahl
 */
public class Program {
    private final MenuCard menu = new MenuCard(); 
    private final DatabaseHandler databaseHandler; 
    
    
    public Program(DatabaseHandler databaseHandler, DataSource dataSource){
        this.menu.setMenu(dataSource.getPizzas()); 
        this.databaseHandler = databaseHandler; 
    }
    
}
