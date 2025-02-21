/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author HELLO
 */
import com.connect.DBContext;
import com.entity.Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thuongnnse05095
 */
public class InfoModel {

    private final DBContext db;

    public InfoModel() throws Exception {
        db = new DBContext();
    }

    public ArrayList<Information> getInfoPage() throws Exception {
        String query = "select * from Information";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Information> output = new ArrayList<>();

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String content = rs.getString(3);
                Information i = new Information(id, name, content);
                output.add(i);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.close(conn, ps, rs);
        }

        return output;
    }

    public String getAddress(List<Information> info) throws Exception {
        for (Information in : info) {
            if (in.getName().equals("address")) {
                return in.getContent();
            }
        }
        return "";
    }

    public String getTel(List<Information> info) throws Exception {
        for (Information in : info) {
            if (in.getName().equals("tel")) {
                return in.getContent();
            }
        }
        return "";
    }

    public String getMail(List<Information> info) throws Exception {
        for (Information in : info) {
            if (in.getName().equals("mail")) {
                return in.getName() + ":" + in.getContent();
            }
        }
        return "";
    }

    public List getOpenHours(List<Information> info) throws Exception {
        List<String> days = new ArrayList<>();
        for (Information in : info) {
            if (in.getName().contains("day")) {
                days.add(in.getName() + ": " + in.getContent());
            }
        }
        return days;
    }

    public String getUrlCover(List<Information> info) throws Exception {
        for (Information in : info) {
            if (in.getName().equals("imgCover")) {
                return in.getContent();
            }
        }
        return "";
    }
}