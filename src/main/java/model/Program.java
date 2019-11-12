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
    private Customer customer = new Customer(); 
    private Order order; 
    private String paymentType = ""; 

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
            ui.println("5) Betal ordre og print kvittering");
            ui.println("6) Print kvittering");

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
                        payForOrder(); 
                        break;
                    case 6:
                        printReceipt();
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
        int orderNr = orderMapper.countOrders(); 
        order = new Order(orderNr, pizzas); 
        customer = makeCustomerInfo(); 
        orderMapper.insertOrders(order,customer); 
        //TODO: Skal skrive til database og kalde metoden makeDatating tam taga 
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

    private void showOrders() {
        ArrayList<Order> orders = orderHandler.getOrders(); 
        for (Order order : orders) {
            ui.println(order.toString()); 
        }
        
        ui.println("Dit opgivede tlf nummer er: " + customer.getTele());
    }

    private Customer makeCustomerInfo() {
        //nummer
        int tele = Integer.parseInt(ui.getInput());
        customer.setTele(tele); 
        return customer; 
    }

    private void payForOrder() {
        int totalPrice = order.getTotalPrice(); 
        System.out.println("Samlet pris for dit køb er");
        System.out.println(totalPrice);
        System.out.println("Indtast din ønskede betalingsform");
        paymentType = ui.getInput(); 
        System.out.println("Du valgte at betale med " + paymentType);
        System.out.println("Udfør venligst betalingen nu med beløbet " + totalPrice + " kr");
    }
    
    public void printReceipt(){
        System.out.println(order.toString() + " Betalingsform: " + paymentType);
    }

}
