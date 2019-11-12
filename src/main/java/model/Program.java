package model;

import UI.ConsoleUI;
import datasource.DataSource;
import datasource.OrderMapper;
import java.util.ArrayList;

/**
 *
 * @author FrederikDahl
 */
public class Program {

    private final MenuCard menu = new MenuCard();
    private final OrderHandler orderHandler;
    private final ConsoleUI ui;
    private final DataSource datasource; 
    private final OrderMapper orderMapper;
    private final Customer customer = new Customer(); 

    public Program(ConsoleUI ui, OrderHandler orderHandler, DataSource dataSource, OrderMapper orderMapper) {
        this.menu.setMenu(dataSource.getPizzas());
        this.orderHandler = orderHandler;
        this.ui = ui;
        this.datasource = dataSource; 
        this.orderMapper = orderMapper;
    }

    public void runProgram() {
        int choice = 0;
        while (choice != 7) {
            ui.println("--------------------------------Mario's Pizza System--------------------------------");
            ui.println("1) Skriv dit telefonnummer");
            ui.println("2) Se menukort");
            ui.println("3) Lav ordre");
            ui.println("4) Se ordre");
            ui.println("5) Afslut ordre og print kvittering");
            ui.println("6) Afslut");

            try {
                choice = Integer.parseInt(ui.getInput());
                if (choice < 1 || choice > 6) {
                    throw new NumberFormatException();
                }

                switch (choice) {
                    case 1:
                        makeCustomerInfo(); 
                        break;
                    case 2:
                         showMenucard();
                        break;
                    case 3: 
                        
                        makeOrder();
                        break;
                    case 4:
                        showOrders();
                        break;
                    case 5:
                        break;
                    case 6:
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
        orderHandler.makeOrder(pizzas); 
        Order order = new Order(pizzas); 
        orderMapper.insertOrders(order); 
        //TODO: Skal skrvie til database og kalde metoden makeDatating tam taga 
        //TODO: Skrive til fil 
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
//                        System.out.println("Du har valgt " + chosenPizzas.get(choice));
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

    private void showOrders() {
        ArrayList<Order> orders = orderHandler.getOrders(); 
        for (Order order : orders) {
            ui.println(order.toString()); 
        }
        
        ui.println("Dit opgivede tlf nummer er: " + customer.getTele());
    }

    private void makeCustomerInfo() {
        //Navn og nummer
        int tele = Integer.parseInt(ui.getInput());
        customer.setTele(tele); 
        System.out.println("Dit indtastede nummer er: ");
        System.out.println(customer.getTele());
    }

}
