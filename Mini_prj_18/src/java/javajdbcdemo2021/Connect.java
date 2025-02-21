package javajdbcdemo2021;

import Database.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {

    public static void main(String[] args) {
        // JDBC driver name and database URL
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Student;encrypt=true;trustServerCertificate=true;";
        String user = "sa";
        String pass = "sa";

        try {
            // Step 1: Load the JDBC driver
            Class.forName(driverName);
            try {
                // Step 2: Establish a connection
                Connection con = DriverManager.getConnection(url, user, pass);

                // Step 3: Create a statement object
                Statement stmt = con.createStatement();

                // Step 4: Execute a SQL query
                String sql = "SELECT * FROM Student";
                ResultSet result = stmt.executeQuery(sql);

                // Step 5: Process the result set
                while (result.next()) {
                    String number = result.getString(1).trim();
                    String name = result.getString(2).trim();
                    String course = result.getString(3).trim();
                    Student tempStudent = new Student(number, name, course);
                    System.out.println(tempStudent);
                }

                // Step 6: Close the resources
                result.close();
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

