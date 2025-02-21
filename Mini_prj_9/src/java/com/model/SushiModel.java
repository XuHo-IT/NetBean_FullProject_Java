package com.model;

import com.entity.Sushi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SushiModel {

    private final Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public SushiModel(Connection con) {
        this.con = con;
    }

    public List<Sushi> getAllSushi() {
        List<Sushi> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM Menu";
            pstmt = this.con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Sushi sushi = new Sushi();
                sushi.setId(rs.getInt("id"));
                sushi.setName(rs.getString("name"));
                sushi.setPrice(rs.getFloat("price"));
                sushi.setContent(rs.getString("content"));
                list.add(sushi);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public int getNoOfRecords() {
        int noOfRecords = 0;
        try {
            String query = "SELECT COUNT(*) FROM Menu";
            pstmt = this.con.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                noOfRecords = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return noOfRecords;
    }
}
