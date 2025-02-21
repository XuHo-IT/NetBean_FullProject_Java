<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page import="java.util.List" %>
<%@ page import="com.DAO.BookDAOImpl" %>
<%@ page import="com.DB.DBConnect" %>
<%@ page import="com.entity.BookDtls" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Triangle Result</title>
        <jsp:include page="all_component/allcss.jsp" />
    </head>
    <body style=" background-color: #cfd8dc ">
        <div class="container-fluid" 
             style="height:20px;background-color:#455a64 ">     
        </div>
        <jsp:include page="all_component/navbar.jsp" />
        <div class="container-fluid back-img" >
            <h2 class="text-center text-white">Checker Book Manegement System</h2>
        </div>
        <!-- Recent book -->
        <div class="container recent-book" >
            <h3 class="text-center">Recent Book</h3>
            <div class="row">
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="img/ss1.jpg" style="width:150px;height:200px" class="img-thumblin"/> 
                            <p>Harry Potter 1</p>
                            <p>Description</p>
                            <p>Category: New</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i>Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">300</a>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="img/ss2.jpg" style="width:150px;height:200px" class="img-thumblin"/> 
                            <p>Harry Potter 2</p>
                            <p>Description</p>
                            <p>Category: Old</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2">Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">500</a>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="img/ss3.jpg" style="width:150px;height:200px" class="img-thumblin"/> 
                            <p>Harry Potter 3</p>
                            <p>Description</p>
                            <p>Category: New</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2">Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">200</a>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img src="img/ss4.webp" style="width:150px;height:200px" class="img-thumblin"/> 
                            <p>Harry Potter 4</p>
                            <p>Description</p>
                            <p>Category:Old</p>
                            <div class="row">
                                <a href="" class="btn btn-danger btn-sm ml-2">Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                                <a href="" class="btn btn-danger btn-sm ml-1">400</a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="text-center ml-1">
            <a href="" class="btn btn-danger btn-sm text-while">View All</a>
            <!-- End recent book -->
            <hr>
            <!-- New book -->
           <div class="container new-book">
        <h3 class="text-center">New Book</h3>
        <div class="row">
            <% 
                BookDAOImpl daoNew = new BookDAOImpl(DBConnect.getConn());
                List<BookDtls> newList = daoNew.getNewBook();
                for (BookDtls b : newList) {
            %>
            <div class="col-md-3">
                <div class="card crd-ho">
                    <div class="card-body text-center">
                        <img src="img/<%=b.getPhotoName()%>" style="width:150px;height:200px" class="img-thumblin"/> 
                        <p><%= b.getBookName() %></p>
                        <p><%= b.getAuthor() %></p>
                        <p>Category: <%= b.getBookCategory() %></p>
                        <div class="row">
                            <a href="" class="btn btn-danger btn-sm ml-2">Add Cart</a>
                            <a href="" class="btn btn-success btn-sm ml-1">View Details</a>
                            <a href="" class="btn btn-danger btn-sm ml-1"><%= b.getPrice() %><i class="fa-solid fa-dollar-sign"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <% 
                }
            %>
        </div>
    </div>
        
        
        
    <!-- End new book -->
    <hr>
    <!-- Old book -->
    <div class="container old-book" >
        <h3 class="text-center">Old Book</h3>
        <div class="row">
            <div class="col-md-3">
                <div class="card crd-ho">
                    <div class="card-body text-center">
                        <img src="img/ss1.jpg" style="width:150px;height:200px" class="img-thumblin"/> 
                        <p>Harry Potter 1</p>
                        <p>Description</p>
                        <p>Category: New</p>
                        <div class="row">

                            <a href="" class="btn btn-danger btn-sm ml-5">View Details</a>
                            <a href="" class="btn btn-danger btn-sm ml-1">300</a>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card crd-ho">
                    <div class="card-body text-center">
                        <img src="img/ss2.jpg" style="width:150px;height:200px" class="img-thumblin"/> 
                        <p>Harry Potter 2</p>
                        <p>Description</p>
                        <p>Category: Old</p>
                        <div class="row">

                            <a href="" class="btn btn-danger btn-sm ml-5">View Details</a>
                            <a href="" class="btn btn-danger btn-sm ml-1">500</a>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card crd-ho">
                    <div class="card-body text-center">
                        <img src="img/ss3.jpg" style="width:150px;height:200px" class="img-thumblin"/> 
                        <p>Harry Potter 3</p>
                        <p>Description</p>
                        <p>Category: New</p>
                        <div class="row">

                            <a href="" class="btn btn-danger btn-sm ml-5">View Details</a>
                            <a href="" class="btn btn-danger btn-sm ml-1">200</a>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card crd-ho">
                    <div class="card-body text-center">
                        <img src="img/ss4.webp" style="width:150px;height:200px" class="img-thumblin"/> 
                        <p>Harry Potter 4</p>
                        <p>Description</p>
                        <p>Category:Old</p>
                        <div class="row">

                            <a href="" class="btn btn-danger btn-sm ml-5">View Details</a>
                            <a href="" class="btn btn-danger btn-sm ml-1">400</a>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="text-center ml-1">
        <a href="" class="btn btn-danger btn-sm text-while">View All</a>
        <!-- End old book -->
        <hr>

        <jsp:include page="all_component/footer.jsp"/> 

        </body>
        </html>
