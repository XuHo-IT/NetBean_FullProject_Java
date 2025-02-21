<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add new magazine</title>
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
        form {
            max-width: 400px;
            margin: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add new magazine!</h1>

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

        <form action="NewMagazineController" method="post">
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text" class="form-control" id="id" name="id">
            </div>
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" class="form-control" id="title" name="title">
            </div>
            <div class="form-group">
                <label for="publisher">Publisher:</label>
                <input type="text" class="form-control" id="publisher" name="publisher">
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="text" class="form-control" id="price" name="price">
            </div>
            <button type="submit" class="btn btn-primary">Add Magazine</button>
           
        </form>
         <form action="index.jsp" method="post">
            <br><br>
            <button type="submit" class="btn btn-primary">Back to Magazine</button>
            </form>
    </div>

    <!-- Bootstrap JS and dependencies (optional for functionality) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
