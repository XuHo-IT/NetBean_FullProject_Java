package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class MainforConnectJDBC {

    public static void main(String[] args) {
        try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=db1_prj;encrypt=true;trustServerCertificate=true;";
            String user = "sa";
            String pass = "sa";
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "SELECT * from Student";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int idDB = result.getInt(1);
                String hoDB = result.getString(2);
                String tenDB = result.getString(3);
                int phoneDB = result.getInt(4);
                String addressDB = result.getString(5);
                Student tempStudent = new Student(idDB, hoDB, tenDB, phoneDB, addressDB);
                System.out.println("" + tempStudent.toString());
            }
            result.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainforConnectJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
