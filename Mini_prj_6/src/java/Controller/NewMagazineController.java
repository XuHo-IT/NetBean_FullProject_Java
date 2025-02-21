package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Magazine;
import model.MagazinesDAO;


public class NewMagazineController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String publisher = request.getParameter("publisher");
        String p = request.getParameter("price");

        String validationMessage = Validation(id, title, publisher, p);

        if (!validationMessage.isEmpty()) {
            request.setAttribute("message", validationMessage);
            request.getRequestDispatcher("/new-magazine-result.jsp").forward(request, response);
            return; // Exit the method if validation fails
        }

        try {
            Magazine m = new Magazine(id, title, publisher, Double.parseDouble(p));
            MagazinesDAO dao = new MagazinesDAO();
            if (dao.newMagazine(m)) {
                request.setAttribute("message", "New Magazine Inserted!!!");
            } else {
                request.setAttribute("message", "FAIL");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("message", "ERROR: Price must be a valid number");
            e.printStackTrace();
        } catch (Exception e) {
            request.setAttribute("message", "ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        request.getRequestDispatcher("/new-magazine-result.jsp").forward(request, response);
    }

    public String Validation(String id, String title, String publisher, String priceString) {
        if (!id.matches("^M\\d{3}$")) {
            return "Magazine ID must follow M + 3 digits";
        }

        MagazinesDAO dao = new MagazinesDAO();
        ArrayList<Magazine> list = dao.getAll(id);

        if (!list.isEmpty()) {
            return "This magazine ID already exists";
        }

        if (title.isEmpty()) {
            return "Please input title";
        }

        if (publisher.isEmpty()) {
            return "Please input publisher";
        }

        try {
            double price = Double.parseDouble(priceString);
        } catch (NumberFormatException e) {
            return "Price must be a number";
        }

        return "";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Handles adding a new magazine to the database";
    }
}
