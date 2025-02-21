/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Contact;

/**
 *
 * @author OS
 */
public class ContactDAO {

    private final Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ContactDAO(Connection con) {
        this.con = con;
    }

    public boolean addContact(Contact b) {
        boolean f = false;
        try {
            String sql = "INSERT INTO Contact (firstName, lastName, groups, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, b.getFirstName());
            ps.setString(2, b.getLastName());
            ps.setString(3, b.getGroup());
            ps.setInt(4, b.getPhone());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
                System.out.println("Contact added successfully.");
            } else {
                System.out.println("Failed to add contact.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    public List<Contact> getContact() {
        List<Contact> list = new ArrayList<>();
        try {
            String query = "select * from Contact";
            pstmt = this.con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setFirstName(rs.getString("firstName"));
                contact.setLastName(rs.getString("lastName"));
                contact.setGroup(rs.getString("groups"));
                contact.setPhone(rs.getInt("phone"));
                list.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }
     
    public Contact getContactById(int id) {
        Contact b = null;
        try {
            String sql = "select * from Contact where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                b = new Contact();
                b.setId(rs.getInt("id")); 
                b.setFirstName(rs.getString("firstName"));
                b.setLastName(rs.getString("lastName"));
                b.setGroup(rs.getString("groups"));
                b.setPhone(rs.getInt("phone"));                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public boolean updatedEditContact(Contact b) {
        boolean f = false;
        try {
            String sql = "update contact set firstName=?,lastName=?,groups=?,phone=? where Id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, b.getFirstName());
            ps.setString(2, b.getLastName());
            ps.setString(3, b.getGroup());
            ps.setInt(4, b.getPhone());
            ps.setInt(5, b.getId());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

  
    public boolean deleContact(int id) {
        boolean f = false;
        try {
            String sql = "delete from contact where Id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}
