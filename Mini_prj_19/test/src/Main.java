import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa"); // Set username
        ds.setPassword("sa"); // Set password
        ds.setServerName("LAPTOP-J2C58V8K\\SQLEXPRESS"); // Set server name
        ds.setPortNumber(1433); // Set port number
        ds.setDatabaseName("LAB4"); // Set database name

        // Use connection property in the connection URL to enable encryption
        ds.setURL("jdbc:sqlserver://LAPTOP-J2C58V8K\\SQLEXPRESS:1433;databaseName=LAB4;encrypt=true;trustServerCertificate=true");

        try (Connection con = ds.getConnection()) {
            System.out.println("Success");
            System.out.println(con.getCatalog());
            System.out.println(con.getMetaData());
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
