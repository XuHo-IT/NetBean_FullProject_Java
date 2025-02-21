<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/includes/header.jsp" %>
<%@include file="/includes/column_left_home.jsp" %>
<jsp:useBean id="sList" class="model.StudentList" scope="application"></jsp:useBean>



<section>
    <h1>Student List</h1>
    <br><br>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Date of Birth</th>
        </tr>
        <%
            model.StudentList studentList = (model.StudentList) application.getAttribute("sList");
            if (studentList != null) {
                for (model.Student student : studentList.getList()) {
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getGender() %></td>
            <td><%= student.getDob() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</section>

<!-- end the middle column -->

<%@include file="/includes/column_right_news.jsp" %>
<%@include file="/includes/footer.jsp" %>
