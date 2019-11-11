package model;

import UI.UI;
import datasource.DataSource;
import datasource.DatabaseHandler;
/**
 *
 * @author FrederikDahl
 */
public class Program {
    private final MenuCard menu = new MenuCard(); 
    private final DatabaseHandler databaseHandler; 
    private final UI ui; 
    
    
    
    public Program(UI ui, DatabaseHandler databaseHandler, DataSource dataSource){
        this.menu.setMenu(dataSource.getPizzas()); 
        this.databaseHandler = databaseHandler; 
        this.ui = ui;
    }
    
    public void runProgram() {
        int choice = 0; 
        while (choice != 5) {
            ui.println("--------------------------------Mario's Pizza System--------------------------------");
            ui.println("1) Se menukort");
            ui.println("2) Lav ordre");
            ui.println("3) Se ordre");
            ui.println("4) Afslut ordre");
            ui.println("5) Se statistik");
            ui.println("6) Print kvittering");
            ui.println("7) Afslut");
            
            try {
                if (choice < 1 || choice > 6) {
                    throw new NumberFormatException();
                }
                
                switch (choice) {
                    case 1:
                        showMenucard();
                        
                }
                
            } catch(NumberFormatException e) {
                
            }
        }
    }

    private void showMenucard() {
        ui.println("--------------------------------Mario's Menukort--------------------------------");
        MenuCard menuCard = new MenuCard();
        menuCard.getMenu();

    

    
}
    
}
