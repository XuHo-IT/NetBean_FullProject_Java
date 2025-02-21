<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checker Book Register</title>
        <jsp:include page="all_component/allcss.jsp"/>
    </head>
    <body style="background-color: #cfd8dc">
        <jsp:include page="all_component/navbar.jsp"/>
        <div class="container p-2">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="text-center">Register Page</h5>
                            <c:if test="${not empty succMsg}">
                                <p class="text-center text-success">${succMsg}</p>
                                 <c:remove var="succMsg" scope="session"/>
                            </c:if>
                                
                            <c:if test="${not empty failedMsg}">
                                <p class="text-center text-danger">${failedMsg}</p>
                                <c:remove var="failedMsg" scope="session"/>
                            </c:if>
                            <form action="RegisterController" method="post">
                                <div class="mb-3">
                                    <label for="name" class="form-label">Name</label>
                                    <input type="text" class="form-control" id="name" name="name">
                                </div>
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" class="form-control" id="password" name="password">
                                </div>
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" class="form-control" id="email" name="email">
                                </div>
                                <div class="mb-3">
                                    <label for="phno" class="form-label">Phone</label>
                                    <input type="text" class="form-control" id="phno" name="phno">
                                </div>
                                <div class="mb-3 form-check">
                                    <input type="checkbox" class="form-check-input" id="check" name="check">
                                    <label class="form-check-label" for="check">Agree to terms & conditions</label>
                                </div>
                                <button type="submit" class="btn btn-primary">Register</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-register">
            <jsp:include page="all_component/footer.jsp"/> 
        </div>
    </body>
</html>
