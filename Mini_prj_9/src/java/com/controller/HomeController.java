/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.controller;


import com.entity.Information;
import com.model.ArticleModel;
import com.model.InfoModel;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HELLO
 */
public class HomeController extends HttpServlet {
   
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
        try {
            ArticleModel model = new ArticleModel();
            InfoModel infoModel = new InfoModel();
            List<Information> info = infoModel.getInfoPage();
            int page = 1, pageSize = 2;
            int totalPage = model.getTotalRows(); // get number of content in DB

            if (request.getParameter("page") != null) { // check param page
                page = Integer.parseInt(request.getParameter("page")); // get param page
            }

            if (totalPage % pageSize == 0) { // calculator total page to show information
                totalPage = totalPage / pageSize;
            } else {
                totalPage = totalPage / pageSize + 1;
            }

            if (page > totalPage) {
                request.setAttribute("noContent", "No article here!");
            } else {
                request.setAttribute("content", model.getArticlesFromTo(page, pageSize));
            }
            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("urlCover", infoModel.getUrlCover(info));
            request.setAttribute("active", "HomeColor");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("error.jsp");
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
