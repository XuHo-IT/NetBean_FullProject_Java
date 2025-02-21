/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class RoomServices {
     private final Connection con;
     private PreparedStatement pstmt;
     private ResultSet rs;
     public RoomServices(Connection con) {
        this.con = con;
    }
     public List<Room> Rooms() {
        List<Room> list = new ArrayList<>();
        try {
            String query = "select * from rooms";
            pstmt = this.con.prepareStatement(query);
            
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("roomid"));
                room.setRoomtype(rs.getString("roomtype"));
                room.setCapacity(rs.getInt("capacity"));
                room.setPrice(rs.getFloat("price"));
                room.setStatus(rs.getString("status"));
                room.setMessages(rs.getString("messages"));
                list.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }
}

