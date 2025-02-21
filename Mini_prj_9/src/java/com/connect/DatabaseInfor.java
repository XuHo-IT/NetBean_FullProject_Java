/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HELLO
 */
public interface DatabaseInfor {
    public static String driverName ="com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    public static String url="jdbc:sqlserver://DESKTOP-VOJ939D:1433;databaseName=Sushi"; 
    public static String user="sa";
    public static String pass="sa123"; 
}
