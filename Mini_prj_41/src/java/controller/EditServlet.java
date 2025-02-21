package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;
import model.StudentList;

public class EditServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().println("<!DOCTYPE html>");
            response.getWriter().println("<html>");
            response.getWriter().println("<head>");
            response.getWriter().println("<title>Servlet EditServlet</title>");
            response.getWriter().println("</head>");
            response.getWriter().println("<body>");
            response.getWriter().println("<h1>Servlet EditServlet at " + request.getContextPath() + "</h1>");
            response.getWriter().println("</body>");
            response.getWriter().println("</html>");
        } catch (IOException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        StudentList sList = (StudentList) session.getAttribute("sList");
        if (sList == null) {
            try {
                sList = new StudentList();
                session.setAttribute("sList", sList);
            } catch (ParseException ex) {
                Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        switch (action) {
            case "Delete":
                sList.delete(id);
                request.getRequestDispatcher("list.jsp").forward(request, response);
                break;
            case "Update":
                Student student = sList.getStudent(id);
                session.setAttribute("student", student);
                request.getRequestDispatcher("update.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        StudentList sList = (StudentList) session.getAttribute("sList");

        if (sList == null) {
            try {
                sList = new StudentList();
                session.setAttribute("sList", sList);
            } catch (ParseException ex) {
                Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (action != null && (action.equals("Confirm") || action.equals("Update"))) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String dobStr = request.getParameter("dob");
            String genderStr = request.getParameter("gender");
            boolean gender = genderStr.equalsIgnoreCase("Male");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = null;
            try {
                dob = sdf.parse(dobStr);
            } catch (ParseException e) {
                response.getWriter().println("Error parsing date: " + e.getMessage());
                return;
            }

            Student student = new Student(id, name, gender, dob);
            if (action.equals("Confirm")) {
          
                sList.add(student);
            } else if (action.equals("Update")) {
            
                sList.update(student);
            }
            
            response.sendRedirect("list.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
