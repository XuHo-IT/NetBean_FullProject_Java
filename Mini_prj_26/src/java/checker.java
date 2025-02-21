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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class checker extends HttpServlet {

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
            out.println("<title>Servlet checker</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet checker at " + request.getContextPath() + "</h1>");
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
    String num1 = request.getParameter("canh1");
    String num2 = request.getParameter("canh2");
    String num3 = request.getParameter("canh3");

    TriModel model = new TriModel();
    if (model.isAbove(Double.parseDouble(num1)) && model.isAbove(Double.parseDouble(num2)) && model.isAbove(Double.parseDouble(num3))) {

        if (model.isTamGiac(Double.parseDouble(num1), Double.parseDouble(num2), Double.parseDouble(num3))) {
            Double cv = model.tinhChuVi(Double.parseDouble(num1), Double.parseDouble(num2), Double.parseDouble(num3));
            Double dt = model.tinhDienTich(Double.parseDouble(num1), Double.parseDouble(num2), Double.parseDouble(num3));
            request.setAttribute("chuvi", cv);
            request.setAttribute("dientich", dt);
            request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("failedMsg", "Not a triangle ");
            response.sendRedirect("index.html");
        }
    } else {
        HttpSession session = request.getSession();
        session.setAttribute("failedMsg", "The triangle edge can not be smaller than 0 ");
        response.sendRedirect("index.html");
    }
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
