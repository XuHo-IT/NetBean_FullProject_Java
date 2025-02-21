package controller;

import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import model.StudentList;

public class SearchServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        String sCriteria = request.getParameter("sCriteria");
        String sValue = request.getParameter("sValue").trim();
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();
        model.StudentList sList = (model.StudentList) context.getAttribute("sList");

        if (sList == null) {
            sList = new StudentList();
            session.setAttribute("sList", sList);
        }

        List<Student> searchResult = new ArrayList<>();
        String message = null;

        switch (sCriteria) {
            case "All":
                searchResult = sList.getList();
                message = "Displaying all students.";
                break;
            case "ID":
                try {
                int id = Integer.parseInt(sValue);
                searchResult = sList.searchByID(id);
                if (searchResult.isEmpty()) {
                    message = "No student found with ID: " + sValue;
                } else {
                    message = "Search results for ID: " + sValue;
                }
            } catch (NumberFormatException e) {
                message = "Invalid ID format.";
            }
            break;
            case "Name":
                searchResult = sList.searchByName(sValue);
                if (searchResult.isEmpty()) {
                    message = "No student found with name: " + sValue;
                } else {
                    message = "Search results for name: " + sValue;
                }
                break;
            default:
                message = "Invalid search criteria.";
                break;
        }

        request.setAttribute("sCriteria", sCriteria);
        request.setAttribute("sValue", sValue);
        request.setAttribute("message", message);
        request.setAttribute("searchResult", searchResult);

        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "SearchServlet for student search functionality.";
    }
}
