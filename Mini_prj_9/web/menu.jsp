<%@page import="com.model.SushiModel"%>
<%@page import="com.connect.DBContext"%>
<%@page import="com.entity.Sushi"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Menu Page</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link href="css/menu.css" rel="stylesheet" type="text/css"/>
    <link href="css/header.css" rel="stylesheet" type="text/css"/>
    <link href="css/footer.css" rel="stylesheet" type="text/css"/>
    <link href="css/container.css" rel="stylesheet" type="text/css"/>
</head>
<body>     
    <div class="wrap">
        <%@include file="header.jsp" %>
        <div class="content">
            <div class="main-content">
                <div class="content-left">
                    <h2>Menu and Price list</h2>
                    <c:if test="${not empty noContent}">
                        <h3>${noContent}</h3>
                    </c:if>
                    <c:if test="${empty noContent}">    
                        <%
                            DBContext dbContext = new DBContext();
                            Connection conn = dbContext.getConnection();
                            SushiModel dao = new SushiModel(conn);
                            List<Sushi> list = dao.getAllSushi();
                            int rowNum = 1;
                            for (Sushi sushi : list) {
                        %>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Content</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row"><%= rowNum++ %></th>
                                    <td><%= sushi.getName() %></td>
                                    <td>$<%= sushi.getPrice() %></td>
                                    <td><%= sushi.getContent() %></td>
                                </tr>
                            </tbody>
                        </table>
                        <% 
                            } 
                            conn.close();  
                        %>
                    </c:if>
                    <div class="paging">
                        <c:forEach var="j" begin="1" step="1" end="${totalPage}">
                            <c:if test="${page != j}">
                                <a href="MenuController?page=${j}">${j}</a> |
                            </c:if>
                            <c:if test="${page == j}">
                                ${j} |
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                <%@include file="container.jsp" %>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </div>
</body>
</html>
