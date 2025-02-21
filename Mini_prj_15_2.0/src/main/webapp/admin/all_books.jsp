<%-- 
    Document   : all_books
    Created on : May 13, 2024, 12:23:41 AM
    Author     : ADMIN
--%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.entity.BookDtls"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Books</title>
        <%@include file="allcss.jsp"%>
    </head>
    <body>
      
       
        <%@include file="navbar.jsp"%>
       <h5 class="text-center text-white" style="padding:20px">Hello Admin</h5>
        <c:if test="${not empty succMsg}">
            <p class="text-center text-success">${succMsg}</p>
            <c:remove var="succMsg" scope="session"/>
        </c:if>

        <c:if test="${not empty failedMsg}">
            <p class="text-center text-danger">${failedMsg}</p>
            <c:remove var="failedMsg" scope="session"/>
        </c:if>
        <table class="table ">
            <thead class="bg-primary text-white">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Book Image</th>
                    <th scope="col">Book Name</th>
                    <th scope="col">Author</th>
                    <th scope="col">Categories</th>
                    <th scope="col">Status</th>
                    <th scope="col">Action</th>

                </tr>
            </thead>
            <tbody>
                <%
                BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
                List<BookDtls> list = dao.getAllBooks();
                for(BookDtls b: list){
                %>
                <tr>
                    <td><%=b.getBookID()%></td>
                    <td><img src="../bookimg/<%=b.getPhotoName()%>" style="width:50px;height:50px;"></td>
                    <td><%=b.getBookName()%></td>
                    <td><%=b.getAuthor()%></td>
                    <td><%=b.getBookCategory()%></td>
                    <td><%=b.getStatus()%></td>

                    <td>
                        <a href="editbook.jsp?id=<%=b.getBookID()%>" class="btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square"></i>Edit</a>
                        <a href="../delete?id=<%=b.getBookID()%>" class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i>Delete</a> 
                    </td>
                </tr>
                <%  
                }
                %>
            </tbody>
        </table>
        <div style="margin-top:350px;">
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
