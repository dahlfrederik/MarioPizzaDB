package model;

import UI.ConsoleUI;
import datasource.DataSource;
import datasource.DatabaseHandler;
import java.util.ArrayList;

/**
 *
 * @author FrederikDahl
 */
public class Program {

    private final MenuCard menu = new MenuCard();
    private final DatabaseHandler databaseHandler;
    private final ConsoleUI ui;

    public Program(ConsoleUI ui, DatabaseHandler databaseHandler, DataSource dataSource) {
        this.menu.setMenu(dataSource.getPizzas());
        this.databaseHandler = databaseHandler;
        this.ui = ui;
    }

    public void runProgram() {
        int choice = 0;
        while (choice != 7) {
            ui.println("--------------------------------Mario's Pizza System--------------------------------");
            ui.println("1) Se menukort");
            ui.println("2) Lav ordre");
            ui.println("3) Se ordre");
            ui.println("4) Afslut ordre");
            ui.println("5) Se statistik");
            ui.println("6) Print kvittering");
            ui.println("7) Afslut");

            try {
                choice = Integer.parseInt(ui.getInput());
                if (choice < 1 || choice > 7) {
                    throw new NumberFormatException();
                }

                switch (choice) {
                    case 1:
                        showMenucard();
                        break;
                    case 2:
                        makeOrder();
                        break;
                    case 3: 
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6: 
                        break;
                    case 7:
                        break;
                }

            } catch (NumberFormatException e) {

            }
        }
    }

    private void showMenucard() {
        ui.println("---------------------------------Mario's  Menukort---------------------------------");
        ArrayList<Pizza> menuCard = menu.getMenu();
        for (Pizza pizza : menuCard) {
            ui.println(pizza + " kr."); 
            
        }

    }

    private void makeOrder() {
        ui.println("---------------------------------Lav Ordre---------------------------------");
        ArrayList<Pizza> pizzas = selectPizzas(); 
    }
    
    public ArrayList<Pizza> selectPizzas() {
        int choice = 0;
        int menuSize = menu.getMenu().size();
        ArrayList<Pizza> chosenPizzas = new ArrayList();
        while (choice != -1) {
            showMenucard();
            ui.println("\nVælg pizza eller -1 for at afslutte");
            try {
                choice = Integer.parseInt(ui.getInput());
                if (choice != -1) {
                    if (choice < menuSize + 1 && choice > 0) {
                        Pizza p = menu.getPizza(choice);
                        chosenPizzas.add(p);
                    } else {
                        throw new NumberFormatException();
                    }
                }
            } catch (NumberFormatException e) {
                ui.println("Vælg mellem 1 - " + menuSize);
            }
        }
        return chosenPizzas;
    }

}
