package com.user.servlet;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
            HttpSession session = request.getSession();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
                User us = new User();
                us.setName("admin");
                session.setAttribute("userobj", us);
                response.sendRedirect("admin/home.jsp");
            } else {
                User us = dao.login(email, password);
                if (us != null) {
                    session.setAttribute("userobj", us);
                    response.sendRedirect("admin/home.jsp");
                } else {
                    session.setAttribute("failedMsg", "Email and/or Password Invalid");
                    response.sendRedirect("login.jsp");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
