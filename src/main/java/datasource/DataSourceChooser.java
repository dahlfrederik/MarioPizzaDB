

package datasource;

import dataadmin.DataSources;

/**
 * @author Frederik, Hallur, Josef og Thor
 */
//Vælger datatype 
public class DataSourceChooser {
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
