

package model;

import datasource.DataSource;
import datasource.DatabaseHandler;

/**
 *
 * @author FrederikDahl
 */
public class Program {
    private final MenuCard menu = new MenuCard(); 
    
    
    public Program(DataSource dataSource){
        this.menu.setMenu(dataSource.getPizzas()); 
        
    }
    
}
