<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Result</title>
</head>
<body>
    <form class="a" action="checker" method="POST">
        <c:if test="${not empty succMsg}">
            <p class="text-center text-success">${succMsg}</p>
            <c:remove var="succMsg" scope="session"/>
        </c:if>

        <c:if test="${not empty failedMsg}">
            <p class="text-center text-danger">${failedMsg}</p>
            <c:remove var="failedMsg" scope="session"/>
        </c:if>
        Canh a:<input type="text" name="canh1" value="<%= request.getParameter("canh1")%>"/>
        <br><br>
        Canh b:<input type="text" name="canh2" value="<%= request.getParameter("canh2")%>"/>
        <br><br>
        Canh c:<input type="text" name="canh3" value="<%= request.getParameter("canh3")%>"/>
        <br><br>
        <input type="submit" name="submit" placeholder=""/>
        <br><br>
        Chu vi:<input type="text" name="cv" value="<%= request.getAttribute("chuvi")%>"/>
        <br><br>
        Dien tich:<input type="text" name="dt" value="<%= request.getAttribute("dientich")%>"/>
        <br><br>
    </form>
</body>
</html>
