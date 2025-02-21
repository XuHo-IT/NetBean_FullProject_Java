package context;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB {

    private static ConnectDB instance;

    private ConnectDB() {
       
    }

   
    public Connection openConnection() throws Exception {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-VOJ939D:1433;" +
                "databaseName=Magazine;User=sa;Password=sa123;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(connectionUrl);
        return con;
    }

  
    public static ConnectDB getInstance() {
        if (instance == null) {
            instance = new ConnectDB();
        }
        return instance;
    }
}
