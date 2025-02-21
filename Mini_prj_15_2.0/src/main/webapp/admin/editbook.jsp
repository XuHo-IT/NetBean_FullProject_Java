
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.entity.BookDtls"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Edit Book</title>
        <%@include file="allcss.jsp"%>
    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="text-center">Edit Book</h3>
                        </div>
                        <div class="card-body">
                            <c:if test="${not empty succMsg}">
                                <p class="text-center text-success">${succMsg}</p>
                                <c:remove var="succMsg" scope="session"/>
                            </c:if>

                            <c:if test="${not empty failedMsg}">
                                <p class="text-center text-danger">${failedMsg}</p>
                                <c:remove var="failedMsg" scope="session"/>
                            </c:if>
                            <%
                      BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
                       int id=Integer.parseInt(request.getParameter("id"));
                      BookDtls b = dao.getBookById(id);
                            %>

                            <form action="../EditBook" method="post">
                                <input type="hidden" name="id" value="<%=b.getBookID()%>">
                                <div class="mb-3">
                                    <label for="name" class="form-label">Book Name</label>
                                    <input type="text" class="form-control" id="name" name="name" value="<%=b.getBookName()%>">
                                </div>
                                <div class="mb-3">
                                    <label for="author" class="form-label">Author Name</label>
                                    <input type="text" class="form-control" id="author" name="author" value="<%=b.getAuthor()%>">
                                </div>
                                <div class="mb-3">
                                    <label for="price" class="form-label">Price</label>
                                    <input type="number" class="form-control" id="price" name="price" value="<%=b.getPrice()%>">
                                </div>
                                <div class="mb-3">
                                    <label for="status" class="form-label">Book Status</label>
                                    <select class="form-select form-control" id="status" name="status">
                                        <option selected>Choose...</option>
                                        <% if("Active".equals(b.getStatus())){%>
                                        <option value="Inactive">Inactive</option>
                                        <option value="Active">Active</option>

                                        <% 
                                           }else{%>
                                        <option value="Inactive">Inactive</option>

                                        <option value="Active">Active</option>
                                        <%}
                                        %>
                                    </select>
                                </div>

                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Edit Book</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
