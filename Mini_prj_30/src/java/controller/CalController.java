package controller;

import model.CalculatorModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class CalController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/cal.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String action = request.getParameter("action");
        CalculatorModel model = new CalculatorModel(Float.parseFloat(num1),
                Float.parseFloat(num2), action);
        request.setAttribute("RS", model);
        request.getRequestDispatcher("/WEB-INF/result.jsp").include(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
