<%-- 
    Document   : home
    Created on : May 12, 2024, 10:58:27 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Home</title>
        <%@include file="allcss.jsp"%>
        <c:if test="${empty userobj}">
            <c:redirect url="../login.jsp"/>
        </c:if>
        <style type="text/css">
            a{
                text-decoration: none;
                color:black;
            }
            a:hover{
                text-decoration: none;
                color:black;
            }
        </style>
    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <a href="add_books.jsp">
                        <div class="card">
                            <div class="card-body text-center">
                                <i class="fa-solid fa-square-plus fa-3x text-primary"></i><br>
                                <h4>Add Book</h4>
                                ---------------
                            </div>
                        </div>
                    </a>
                </div>

                <div class="col-md-3">
                    <a href="all_books.jsp">
                    <div class="card">
                        <div class="card-body text-center">
                            <i class="fa-solid fa-book-open fa-3x text-danger"></i><br>
                            <h4>All Book</h4>
                            ---------------
                        </div>
                    </div>
                        </a>
                </div>

                <div class="col-md-3">
                    <a href="orders.jsp">
                    <div class="card">
                        <div class="card-body text-center">
                            <i class="fa-solid fa-cart-shopping fa-3x text-warning"></i><br>
                            <h4>Order</h4>
                            ---------------
                        </div>
                    </div>
                        </a>
                </div>

                <div class="col-md-3">
                    <a href="#" data-toggle="modal" data-target="#exampleModal" >
                         <div class="card">
                        <div class="card-body text-center">
                            <i class="fa-solid fa-right-from-bracket fa-3x text-primary"></i><br>
                            <h4>Logout</h4>
                            ---------------
                        </div>
                    </div>
                    </a>
                   
                </div>
            </div>
        </div>
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
        <div style="margin-top:400px;">
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
