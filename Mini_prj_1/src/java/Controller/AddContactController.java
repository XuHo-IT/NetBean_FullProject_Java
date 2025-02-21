/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Connect.DBConnect;
import DAO.ContactDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Contact;

/**
 *
 * @author OS
 */
public class AddContactController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddContactController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddContactController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String group = request.getParameter("group");
        String phone = request.getParameter("phone");
        HttpSession session = request.getSession();

        String validationMessage = validateContactInput(firstName, lastName, group, phone);

        if (!validationMessage.isEmpty()) {
            request.setAttribute("errorMessage", validationMessage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return; 
        }

        int phoneNum = Integer.parseInt(phone);

        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setGroup(group);
        contact.setPhone(phoneNum);

        ContactDAO dao = new ContactDAO(DBConnect.getConn());
        boolean f = dao.addContact(contact);

        if (f) {
            session.setAttribute("succMsg", "Contact added successfully");
            response.sendRedirect("listContact.jsp");
        } else {
            session.setAttribute("failedMsg", "Failed to add contact");
            response.sendRedirect("index.jsp");
        }
    } catch (NumberFormatException e) {
        request.setAttribute("errorMessage", "Phone number must be numeric.");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private String validateContactInput(String firstName, String lastName, String group, String phone) {
    if (firstName == null || firstName.isEmpty()) {
        return "First name is required.";
    }

    if (lastName == null || lastName.isEmpty()) {
        return "Last name is required.";
    }

    if (group == null || group.isEmpty()) {
        return "Group is required.";
    }

    if (phone == null || phone.isEmpty()) {
        return "Phone number is required.";
    }

    if (!phone.matches("^0\\d{9}$")) {
        return "Phone number must be 10 digits long and start with 0.";
    }

    return "";
}


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
