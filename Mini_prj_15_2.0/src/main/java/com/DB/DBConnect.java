package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADMIN
 */
public class DBConnect {
    private static Connection conn;
    public static Connection getConn(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Ebook-App;encrypt=true;trustServerCertificate=true;";
            String username = "sa"; // Replace 'your_username' with your SQL Server username
            String password = "sa"; // Replace 'your_password' with your SQL Server password
            conn = DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

}
