

package model;

import datasource.DataSource;
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
