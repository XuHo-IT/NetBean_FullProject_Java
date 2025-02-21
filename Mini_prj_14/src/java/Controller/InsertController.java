package Controller;

import Connect.DBContext;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Human;
import model.HumanType;

@WebServlet(name = "InsertController", urlPatterns = {"/InsertController"})
public class InsertController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBContext db = new DBContext();
        ArrayList<HumanType> types = db.getTypes();
        request.setAttribute("types", types);
        request.getRequestDispatcher("insert.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String humanId = request.getParameter("id");
        String humanName = request.getParameter("name");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String typeId = request.getParameter("typeId");

        int id = Integer.parseInt(humanId);
        int typeIdValue = Integer.parseInt(typeId);
        boolean isMale = gender.equalsIgnoreCase("Male");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dobDate = null;
        try {
            dobDate = sdf.parse(dob);
        } catch (ParseException ex) {
            Logger.getLogger(InsertController.class.getName()).log(Level.SEVERE, null, ex);
        }

        HumanType humanType = new HumanType();
        humanType.setTypeId(typeIdValue);
        Human human = new Human(id, humanName, dobDate, isMale, humanType);

        DBContext dbContext = new DBContext();
        dbContext.addHuman(human);

        response.sendRedirect("list.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
