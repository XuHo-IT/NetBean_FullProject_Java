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
import model.Group;

/**
 *
 * @author OS
 */
public class GroupDAO {
      private final Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public GroupDAO(Connection con) {
        this.con = con;
    }

    public boolean addgroup(Group b) {
        boolean f = false;
        try {
            String sql = "INSERT INTO [Contact].[dbo].[Group] (groupName, description) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, b.getGroupName());
            ps.setString(2, b.getDescription());          
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
                System.out.println("Group added successfully.");
            } else {
                System.out.println("Failed to add group.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    public List<Group> getGroup() {
        List<Group> list = new ArrayList<>();
        try {
            String query = "select * from [Contact].[dbo].[Group]";
            pstmt = this.con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setId(rs.getInt("id"));
                group.setGroupName(rs.getString("groupName"));
                group.setDescription(rs.getString("description"));              
                list.add(group);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }
}
