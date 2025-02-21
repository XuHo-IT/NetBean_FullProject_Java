<%-- 
    Document   : all_books
    Created on : May 13, 2024, 12:23:41 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Orders</title>
        <%@include file="allcss.jsp"%>
    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <table class="table ">
            <thead class="bg-primary text-white">
                <tr>
                    <th scope="col">Order Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Ph no</th>
                    <th scope="col">Book Name</th>
                    <th scope="col">Author</th>
                    <th scope="col">Price</th>
                    <th scope="col">Payment Type</th>
                </tr>
            </thead>
            
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                    <td>Mark</td>
                    <td>Otto</td>
                   <td>@mdo</td>
                    <td>Mark</td>
                    
                </tr>

                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                    <td>Mark</td>
                    <td>Otto</td>
                   <td>@mdo</td>
                    <td>Mark</td>
                
                </tr>

                <tr>
                    <th scope="row">3</th>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                    <td>Mark</td>
                    <td>Otto</td>
                   <td>@mdo</td>
                    <td>Mark</td>
                  
                </tr>
            </tbody>
        </table>
         <div style="margin-top:350px;">
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
