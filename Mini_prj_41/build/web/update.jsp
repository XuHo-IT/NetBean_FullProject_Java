<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/column_left_home.jsp" %>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<!-- start the middle column -->
<jsp:useBean id="student" class="model.Student" scope="session"/>
<!-- column middle -->
    <session id="main-contain"class="column">
       <form action="EditServlet" method="POST">
            <table boder="1">
                <tr>
                    <td class="form-label" >Student ID</td>
                    <td><input type="text" name="id" size="30" value="${student.id}"></td>
                </tr>
                <tr>
                    <td class="form-label">Full Name</td>
                    <td><input type="text" name="name" size="30" value="${student.name}"></td>
                </tr>
                <tr>
                    <td class="form-label">Gender</td>
                    <td>
                        <input type="radio" name="gender" value="Male" checked="${student.getGender()}">Male
                        <input type="radio" name="gender" value="Female" checked="${!student.getGender()}">Female
                    </td>
                </tr>
                <tr>
                    <td class="form-label">Date of birth</td>
                    <td><input type="text" name="dob" size="30" value="${student.dob}"></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <input type="submit" name="action" value="Update"/>
                        <input type="submit" name="action" value="Confirm"/>
                        <input type="reset" value="Reset"/>
                    </td>
                </tr>
            </table>            
        </form>
    </session>
<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
