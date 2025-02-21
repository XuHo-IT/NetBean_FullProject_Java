package com.controller;

import com.model.SushiModel;
import com.entity.Sushi;
import com.connect.DBContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MenuController extends HttpServlet {

    private Connection conn;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            DBContext dbContext = new DBContext();
            conn = dbContext.getConnection();
        } catch (Exception e) {
            throw new ServletException("Failed to initialize database connection", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 10;
        if (request.getParameter("page") != null) {
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (NumberFormatException e) {
                page = 1; 
            }
        }

        if (conn != null) {
            try {
                SushiModel dao = new SushiModel(conn);
                List<Sushi> list = dao.getAllSushi();
                int noOfRecords = dao.getNoOfRecords();
                int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

                request.setAttribute("sushiList", list);
                request.setAttribute("noOfPages", noOfPages);
                request.setAttribute("currentPage", page);

                request.getRequestDispatcher("menu.jsp").forward(request, response);
            } catch (Exception e) {
                throw new ServletException("Failed to retrieve sushi data", e);
            }
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to connect to the database.");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        if (conn != null) {
            DBContext dbContext = new DBContext();
            try {
                dbContext.close(conn, null, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
