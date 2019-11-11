

package main;

import dataadmin.DataSources;
import datasource.DataSource;
import datasource.DataSourceChooser;
import model.Program;

/**
 *
 * @author FrederikDahl
 */

//Initialisere hele programmet 
public class MarioMain {
    
    public static void main(String[] args) {
        DataSourceChooser DataChooser = new DataSourceChooser(); 
        DataSource datasource =  DataChooser.getDataSource(DataSources.DATABASE); 
        Program program = new Program(datasource); 
        
    }
}
