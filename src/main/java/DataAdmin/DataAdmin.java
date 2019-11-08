package dataadmin;

import datasource.DatabaseHandler;
import datasource.FileHandler;
import datasource.DataSource; 

/**
 * @author FrederikDahl
 */
public class DataAdmin {
        public DataSource getDataSource(DataSources type) {
        if (type == null) {
            return null;
        }
        if (type.equals(DataSources.FILE)) {
            return new FileHandler();

        } else if (type.equals(DataSources.DATABASE)) {
            return new DatabaseHandler();
        }

        return null;
    }
}

