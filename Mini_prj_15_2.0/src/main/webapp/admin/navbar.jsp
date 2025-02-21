<%-- 
    Document   : navbar.jsp
    Created on : May 10, 2024, 11:21:09 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
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
                    <c:if test="${not empty userobj}">
                        <a href="../login.jsp" class="btn btn-success btn1">
                            <i class="fa-solid fa-user"></i>${userobj.name="Admin"}</a>
                        <a   data-toggle="modal" data-target="#exampleModal"                        
                             class="btn btn-primary btn2 text-white">
                            <i class="fa-solid fa-sign-in-alt"></i>Logout</a> 

                    </c:if>
                    <c:if test="${empty userobj}">
                        <a href="../login.jsp" class="btn btn-success btn1"><i class="fa-solid fa-right-to-bracket"></i>Login</a>
                        <a href="../register.jsp" class="btn btn-primary btn2"><i class="fa-solid fa-user-plus"></i>Register</a> 
                    </c:if>


                </div>
            </div>
        </div>

        <!-- logout modal -->
        <!-- Button trigger modal -->

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h4>Do you want to logout?</h4>
                        <div class="text-center">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <a href="../Logout" type="button" class="btn btn-primary">Log out</a>
                        </div>

                    </div>
                    <div class="modal-footer">

                    </div>
                </div>
            </div>
        </div>
        <!-- end modal -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-custom">
            <a class="navbar-brand" href="#"><i class="fa-solid fa-house"></i></a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    </form>
            </div>
        </nav>
    </body>
</html>
