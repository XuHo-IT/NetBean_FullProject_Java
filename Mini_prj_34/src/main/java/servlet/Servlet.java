package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import model.StudentList;

public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        Student stu1 = null;
//        session.removeAttribute("sList");
        try {
            stu1 = new Student(id, name, gender, dob);
        } catch (ParseException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex);
        }
        StudentList sList = (StudentList) session.getAttribute("sList");
        if (sList == null) {
            try {
                sList = new StudentList();
            } catch (ParseException ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                throw new ServletException(ex);
            }
        }
        sList.add(stu1); // Add the new student to the list
        session.setAttribute("sList", sList); // Set the updated list back into the session
        request.getRequestDispatcher("list.jsp").forward(request, response); // Forward to list.jsp
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
