package main;

import UI.ConsoleUI;
import dataadmin.DataSources;
import datasource.DataSource;
import datasource.DataSourceChooser;
import datasource.DatabaseHandler;
import model.Program;

/**
 *
 * @author FrederikDahl
 */

//Initialisere hele programmet 
public class MarioMain {
    
    public static void main(String[] args) {        
        ConsoleUI cUI = new ConsoleUI();
        DataSourceChooser DataChooser = new DataSourceChooser(); 
        DataSource datasource =  DataChooser.getDataSource(DataSources.DATABASE); 
        Program program = new Program(cUI, new DatabaseHandler() ,datasource); 
        program.runProgram();

        
        
    }
}
