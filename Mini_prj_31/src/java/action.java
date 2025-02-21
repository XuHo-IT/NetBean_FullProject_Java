/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class action extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet action</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet action at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String[] authors = request.getParameterValues("author");
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Selected Authors</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h3>Choose an author:</h3>");
    out.println("<form action=\"action\" method=\"get\">");
    out.println("<input type=\"checkbox\" name=\"author\" value=\"Tan Ah Teck Nguyen\" " + (isSelected("Tan Ah Teck Nguyen", authors) ? "checked" : "") + ">Tan Nguyen");
    out.println("<input type=\"checkbox\" name=\"author\" value=\"Mohd Ali Hoag\" " + (isSelected("Mohd Ali Hoag", authors) ? "checked" : "") + ">Ali Hoang");
    out.println("<input type=\"checkbox\" name=\"author\" value=\"Kumar Van\" " + (isSelected("Kumar Van", authors) ? "checked" : "") + ">Kumar Van");
    out.println("<input type=\"submit\" value=\"Query\">");
    out.println("</form>");
    out.println("<h3>You have selected author(s):</h3>");
    if (authors != null && authors.length > 0) {
        for (String author : authors) {
            out.println(author + "<br>");
        }
    } else {
        out.println("None selected<br>");
    }
    out.println("<a href=\"" + request.getRequestURI() + "\">BACK</a>");
    out.println("</body>");
    out.println("</html>");
}

private boolean isSelected(String author, String[] selectedAuthors) {
    if (selectedAuthors != null) {
        for (String selectedAuthor : selectedAuthors) {
            if (selectedAuthor.equals(author)) {
                return true;
            }
        }
    }
    return false;
}



    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
