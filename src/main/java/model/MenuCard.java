

package model;

import java.util.ArrayList;

/**
 *
 * @author FrederikDahl
 */
public class MenuCard {
    
    private ArrayList<Pizza> menu = new ArrayList<Pizza>();
    
    public void addPizza(Pizza pizza) {
        menu.add(pizza);
    }
    
    public void setMenu(ArrayList<Pizza> menuCard){
        this.menu = menuCard; 
    }
    
    public ArrayList<Pizza> getMenu(){
        return menu; 
    } 
    
    @Override
    public String toString() {
        String totalMenu = "";
        totalMenu += "MENUCARD" + "\n"; 
        totalMenu += "*****************" + "\n"; 

        for (Pizza total : menu) {
            totalMenu += "\n"; 
            totalMenu += total.toString() + "\n";
        }
        return totalMenu;
    }
}
