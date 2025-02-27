/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import context.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MagazinesDAO {

    public MagazinesDAO() {
        // Constructor
    }

    public ArrayList<Magazine> getAll(String Id) {
        try {
            // Connect to database
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.openConnection();

            String sql = "SELECT * FROM Magazine";
            if (!Id.isEmpty()) {
                sql += " WHERE ID='" + Id + "'";
            }

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            ArrayList<Magazine> list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("ID");
                String title = rs.getString("Title");
                String publisher = rs.getString("Publisher");
                double price = rs.getDouble("Price");

                Magazine m = new Magazine(id, title, publisher, price);
                list.add(m);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean newMagazine(Magazine m) {
        String sql = "INSERT INTO Magazine VALUES (?, ?, ?, ?)";
        try {
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, m.getID());
            pstmt.setString(2, m.getTitle());
            pstmt.setString(3, m.getPublisher());
            pstmt.setDouble(4, m.getPrice());

            return pstmt.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

