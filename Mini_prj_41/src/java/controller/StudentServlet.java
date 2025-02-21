package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import model.StudentList;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        // Retrieve form data
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String genderStr = request.getParameter("gender");
        String dobStr = request.getParameter("dob");

        // Parse the id to an integer
        int id = Integer.parseInt(idStr);

        // Parse the gender to a boolean
        boolean gender = genderStr.equalsIgnoreCase("Male");

        // Parse the date
        Date dob = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Updated to match the input format
            dob = sdf.parse(dobStr);
        } catch (ParseException e) {
            // Handle parse exception if needed
            response.getWriter().println("Error parsing date: " + e.getMessage());
            return; // Exit method if date parsing fails
        }

        // Create a new Student object
        Student newStudent = new Student(id, name, gender, dob);

        // Retrieve the StudentList from the application scope
        ServletContext context = getServletContext();
        StudentList sList = (StudentList) context.getAttribute("sList");

        // Ensure sList is initialized
        if (sList == null) {
            try {
                sList = new StudentList();
                context.setAttribute("sList", sList);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // Add the new student to the list
        sList.add(newStudent);

        // Update the StudentList in the application scope
        context.setAttribute("sList", sList);

        // Redirect to a confirmation or list page
        response.sendRedirect("list.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
