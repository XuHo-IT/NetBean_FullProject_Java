<%-- 
    Document   : navbar.jsp
    Created on : May 10, 2024, 11:21:09 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style=" background-color: #cfd8dc">
         <div class="container-fluid p-3 bg-light">
            <div class="row">
                <div class="col-md-3 title">
                    <h3><i class="fa-solid fa-explosion"></i>CheckerBooks</h3>
                </div>
                <div class="col-md-6">
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-primary my-2 my-sm-0 btn2" type="submit">Search</button>
                    </form>
                </div>

                <div class="col-md-3 btns1">
                    <a href="login.jsp" class="btn btn-success btn1"><i class="fa-solid fa-right-to-bracket"></i>Login</a>
                    <a href="register.jsp" class="btn btn-primary btn2"><i class="fa-solid fa-user-plus"></i>Register</a> 
                </div>
            </div>
        </div>


        <nav class="navbar navbar-expand-lg navbar-dark bg-custom">
            <a class="navbar-brand" href="#"><i class="fa-solid fa-house"></i></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp#recent-book"><i class="fa-solid fa-book"></i>Recent book <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp#new-book"><i class="fa-solid fa-book-open"></i>New book</a>
                    </li>

                    <li class="nav-item active">
                        <a class="nav-link disabled" href="index.jsp#old-book"><i class="fa-solid fa-book-open"></i>Old book</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">

                    <button class="btn btn-light my-2 my-sm-0" type="submit"><i class="fa-solid fa-gear"></i>Setting</button>
                    <button class="btn btn-light my-2 my-sm-0 ml-1" type="submit"><i class="fa-regular fa-address-book"></i>Contact us</button>

                </form>
            </div>
        </nav>
    </body>
</html>
