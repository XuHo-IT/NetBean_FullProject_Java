<%-- 
    Document   : register
    Created on : Jun 4, 2024, 12:41:31 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <br><br>
    <jsp:include page="header.jsp" />
    <c:if test="${not empty succMsg}">
        <p class="text-center text-success">${succMsg}</p>
        <c:remove var="succMsg" scope="session"/>
    </c:if>

    <c:if test="${not empty failedMsg}">
        <p class="text-center text-danger">${failedMsg}</p>
        <c:remove var="failedMsg" scope="session"/>
    </c:if>

    <form action="RegisterController" method="POST">
        <label>Name:</label>
        <input type="text" name="name" required/><br><br>
        <label>Date of birth:</label>
        <input type="date" name="dob" required/><br><br>
        <label>Phone:</label>
        <input type="text" name="phone" required/><br><br>
        <label>Gender:</label>
        <input type="radio" name="gender" value="Male" required/>Male
        <input type="radio" name="gender" value="Female" required/>Female<br><br>
        <label>Address:</label>
        <input type="text" name="address" required/><br><br>
        <label>Email:</label>
        <input type="email" name="email" required/><br><br>
        <label>Password:</label>
        <input type="password" name="password" required/><br><br>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="check" name="check">
            <label class="form-check-label" for="check">Agree to terms & conditions</label>
        </div>
        <input type="submit" value="Add" />
    </form>
    <jsp:include page="footer.jsp" />

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</html>
