<%@page import="model.Magazine"%>
<%@page import="model.MagazinesDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Magazines</title>
    <!-- Bootstrap CSS link -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <style>
        .container {
            margin-top: 50px;
        }
        h1 {
            margin-bottom: 30px;
        }
        table {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>List of Magazines</h1>

        <%-- Counting and displaying visits --%>
        <%
            Integer hitsCount = (Integer)application.getAttribute("hitCounter");
            if (hitsCount == null || hitsCount == 0) {
                out.print("Welcome to my website! ");
                hitsCount = 1;
            } else {
                out.print("Welcome back to my website! ");
                hitsCount += 1;
            }
            application.setAttribute("hitCounter", hitsCount);
            out.println("Total number of visits: " + hitsCount);
        %>

        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Publisher</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    MagazinesDAO dao = new MagazinesDAO();
                    ArrayList<Magazine> list = dao.getAll("");
                    for (Magazine m : list) {
                %>
                <tr>
                    <td><%= m.getID() %></td>
                    <td><%= m.getTitle() %></td>
                    <td><%= m.getPublisher() %></td>
                    <td><%= m.getPrice() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <form action="magazine.jsp">
            <br><br>
            <button type="submit" class="btn btn-primary">Add new Magazine</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies (optional for functionality) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
