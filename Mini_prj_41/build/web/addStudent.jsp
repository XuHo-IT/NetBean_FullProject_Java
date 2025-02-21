<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>
<jsp:useBean id="slist" class="model.StudentList" scope="application"></jsp:useBean>



<section>
    <h1>Add New Student to System</h1>
    <br><br>
    <form action="StudentServlet" method="POST">
    <label>Student ID:</label>
    <input type="text" name="id" required/><br><br>
    <label>Student Name:</label>
    <input type="text" name="name" required/><br><br>
    <label>Student Gender:</label>
    <input type="radio" name="gender" value="Male" required/>Male
    <input type="radio" name="gender" value="Female" required/>Female<br><br>
    <label>Student DOB:</label>
    <input type="date" name="dob" required/><br><br>
    <input type="submit" value="Add" />
</form>

</section>

<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
