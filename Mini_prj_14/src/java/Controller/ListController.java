    package Controller;

    import Connect.DBContext;
    import java.io.IOException;
    import java.util.ArrayList;
    import jakarta.servlet.ServletException;

    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import model.Human;


    public class ListController extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            DBContext db = new DBContext();
            ArrayList<Human> humans = db.getHumans();
            request.setAttribute("humans", humans);
            request.getRequestDispatcher("list.jsp").forward(request, response);
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
            return "Short description";
        }
    }
