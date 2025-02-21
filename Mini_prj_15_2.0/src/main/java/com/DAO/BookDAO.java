/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.entity.BookDtls;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface BookDAO {
    public boolean addBooks(BookDtls b);
    public List<BookDtls> getAllBooks();
    public BookDtls getBookById(int id);
    public boolean updatedEditBooks(BookDtls b);
    public boolean deleBook(int id);
    public List<BookDtls> getNewBook();
}
