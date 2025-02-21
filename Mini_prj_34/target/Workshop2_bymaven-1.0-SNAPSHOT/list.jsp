<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Student"%>
<%@page import="model.StudentList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    StudentList sList = (StudentList) session.getAttribute("sList");
    if (sList == null) {
        sList = new StudentList();
        session.setAttribute("sList", sList);
    }

    List<Student> students = sList.getList();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<section id="main-contain" class="column">
    <h1>Student List</h1>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>DOB</th>
        </tr>
        </thead>
        <tbody>
        <% for (Student st : students) { %>
            <tr>
                <td><%= st.getId() %></td>
                <td><%= st.getName() %></td>
                <td><%= st.getGender() %></td>
                <td><%= st.getDob() %></td>
            </tr>
        <% } %>
        </tbody>
    </table>
    
</section>
</body>
</html>
