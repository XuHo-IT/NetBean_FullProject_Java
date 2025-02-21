<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin: Add Book</title>
    <%@include file="allcss.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-header">
                        <h3 class="text-center">Add New Book</h3>
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

                      <form action="../AddBook" method="post" enctype="multipart/form-data">
                            <div class="mb-3">
                                <label for="name" class="form-label">Book Name</label>
                                <input type="text" class="form-control" id="name" name="name">
                            </div>
                            <div class="mb-3">
                                <label for="author" class="form-label">Author Name</label>
                                <input type="text" class="form-control" id="author" name="author">
                            </div>
                            <div class="mb-3">
                                <label for="price" class="form-label">Price</label>
                                <input type="number" class="form-control" id="price" name="price">
                            </div>
                            <div class="mb-3">
                                <label for="category" class="form-label">Book Category</label>
                                <select class="form-select form-control" id="category" name="category">
                                    <option selected>Choose...</option>
                                    <option value="New">New</option>
                                    <option value="old">Old</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="status" class="form-label">Book Status</label>
                                <select class="form-select form-control" id="status" name="status">
                                    <option selected>Choose...</option>
                                    <option value="Inactive">Inactive</option>
                                    <option value="Active">Active</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="image" class="form-label">Upload Photo</label>
                                <input type="file" class="form-control" id="image" name="image">
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Add Book</button>
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
