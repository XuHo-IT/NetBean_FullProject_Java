<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add New Magazine Result</title>
    <!-- Bootstrap CSS link (optional) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <style>
        .container {
            margin-top: 50px;
        }
        h1 {
            margin-bottom: 30px;
        }
        .error-message {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add New Magazine Result</h1>
        
        <% String message = (String) request.getAttribute("message"); %>
        <% if (message.startsWith("ERROR")) { %>
            <p class="error-message"><%= message %></p>
        <% } else { %>
            <p><%= message %></p>
        <% } %>

        <form action="magazine.jsp" method="get">
            <br><br>
            <button type="submit" class="btn btn-primary">Return</button>
            <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
            <input type="hidden" name="title" value="<%= request.getParameter("title") %>">
            <input type="hidden" name="publisher" value="<%= request.getParameter("publisher") %>">
            <input type="hidden" name="price" value="<%= request.getParameter("price") %>">
        </form>
    </div>

    <!-- Bootstrap JS and dependencies (optional for functionality) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
