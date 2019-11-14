package main;

import UI.ConsoleUI;
import dataadmin.DataSources;
import datasource.DataSource;
import datasource.DataSourceChooser;
import datasource.OrderMapper;
import model.OrderHandler;
import model.Program;

/**
 * @author Josef, Thor, Hallur og Frederik 
 */

//Initialisere hele programmet 
public class MarioMain {
    
    public static void main(String[] args) {        
        ConsoleUI cUI = new ConsoleUI();
        DataSourceChooser DataChooser = new DataSourceChooser(); 
        OrderMapper orderMapper = new OrderMapper(); 
        DataSource datasource =  DataChooser.getDataSource(DataSources.DATABASE); 
        Program program = new Program(cUI,  new OrderHandler() ,datasource, orderMapper); 
        program.runProgram();

        
        
    }
}
