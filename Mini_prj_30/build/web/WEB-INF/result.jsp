<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Calculator</h1>
    <%=request.getAttribute("RS")%>
    <hr>
    <form action="CalController" method="GET" >
        <input type="submit" value="Continue"/>
    </form>
</body>
</html>
