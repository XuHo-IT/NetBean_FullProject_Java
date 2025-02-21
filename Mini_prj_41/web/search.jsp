<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>
<jsp:useBean id="sList" class="model.StudentList" scope="session"></jsp:useBean>
<%@page import="java.util.List" %>
<%@page import="model.Student" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>

<!-- start the middle column -->
<section>
    <h1>Student Searching</h1>
    <form action="SearchServlet" method="POST">
        <table>
            <tr>
                <td class="form-label">Student Criteria</td>
                <td>
                    <select name="sCriteria">
                        <option value="All">All</option>
                        <option value="ID">ID</option>
                        <option value="Name">Name</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="form-label">Enter search value</td>
                <td><input type="text" name="sValue" size="25"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>
                    <input type="submit" name="action" value="Search"/>
                    <input type="reset" value="Reset"/>
                </td>
            </tr>
        </table>        
    </form>

    <%
        List<Student> searchResult = (List<Student>) request.getAttribute("searchResult");
        String message = (String) request.getAttribute("message");

        if (message != null) {
            out.println("<p>" + message + "</p>");
        }

        if (searchResult != null && !searchResult.isEmpty()) {
    %>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Date of Birth</th>
                <th>Action</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% for (Student st : searchResult) { %>
            <tr>
                <td><%= st.getId() %></td>
                <td><%= st.getName() %></td>
                <td><%= st.isGender() ? "Male" : "Female" %></td>
                <td><%= st.getDob()%></td>
                <td><a href="EditServlet?action=Update&id=<%= st.getId() %>">Update</a></td>
                <td><a href="EditServlet?action=Delete&id=<%= st.getId() %>">Delete</a></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <% } else if (message == null) { %>
    <p>No students found.</p>
    <% } %>
</section>
<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
