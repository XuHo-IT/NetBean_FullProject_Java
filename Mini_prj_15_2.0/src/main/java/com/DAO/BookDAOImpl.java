/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.entity.BookDtls;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BookDAOImpl implements BookDAO {

    private Connection conn;

    public BookDAOImpl(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean addBooks(BookDtls b) {
        boolean f = false;
        try {
            String sql = "INSERT INTO book_dtls (bookname, author, price, bookCategory, status, photo, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getBookName());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getPrice());
            ps.setString(4, b.getBookCategory());
            ps.setString(5, b.getStatus());
            ps.setString(6, b.getPhotoName());
            ps.setString(7, b.getEmail());
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<BookDtls> getAllBooks() {
        List<BookDtls> list = new ArrayList<>();
        BookDtls b = null;
        try {
            String sql = "select * from book_dtls";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                b = new BookDtls();
                b.setBookID(rs.getInt("bookid")); // Corrected column name
                b.setBookName(rs.getString("bookname"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getString("price"));
                b.setBookCategory(rs.getString("bookCategory")); // Corrected column name
                b.setStatus(rs.getString("status"));
                b.setPhotoName(rs.getString("photo"));
                b.setEmail(rs.getString("email"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public BookDtls getBookById(int id) {
        BookDtls b = null;
        try {
            String sql = "select * from [Ebook-App].[dbo].[book_dtls] where bookid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                b = new BookDtls();
                b.setBookID(rs.getInt("bookID")); // Corrected column name
                b.setBookName(rs.getString("bookname"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getString("price"));
                b.setBookCategory(rs.getString("bookCategory")); // Corrected column name
                b.setStatus(rs.getString("status"));
                b.setPhotoName(rs.getString("photo"));
                b.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean updatedEditBooks(BookDtls b) {
        boolean f = false;
        try {
            String sql = "update book_dtls set bookname=?,author=?,price=?,status=? where bookId=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getBookName());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getPrice());
            ps.setString(4, b.getStatus());
            ps.setInt(5, b.getBookID());

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean deleBook(int id) {
        boolean f = false;
        try {
            String sql = "delete from book_dtls where bookId=?";
            PreparedStatement ps = conn.prepareStatement(sql);
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

    @Override
    public List<BookDtls> getNewBook() {
        List<BookDtls> list = new ArrayList<BookDtls>();
        BookDtls b = null;
        try {
            String sql = "select * from book_dtls where bookCategory=? and status=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "New");
            ps.setString(2, "Active");
            ResultSet rs = ps.executeQuery();
            int i = 1;
            while (rs.next() && i <= 4) {
                b = new BookDtls();
                b.setBookID(rs.getInt("bookid")); // Corrected column name
                b.setBookName(rs.getString("bookname"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getString("price"));
                b.setBookCategory(rs.getString("bookCategory")); // Corrected column name
                b.setStatus(rs.getString("status"));
                b.setPhotoName(rs.getString("photo"));
                b.setEmail(rs.getString("email"));
                list.add(b);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
