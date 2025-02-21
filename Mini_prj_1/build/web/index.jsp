<%@page import="model.Group"%>
<%@page import="DAO.GroupDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Contact"%>
<%@page import="Connect.DBConnect"%>
<%@page import="DAO.ContactDAO"%>
<%@include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageTitle" value="Add a Contact"/>
<h1 class="my-4">Add a Contact</h1>
<form action="AddContactController" method="post">
    <div class="mb-3">
        <label for="firstName" class="form-label">First Name</label>
        <input type="text" class="form-control" id="firstName" name="firstName" required>
    </div>
    <div class="mb-3"> 
        <label for="lastName" class="form-label">Last Name</label>
        <input type="text" class="form-control" id="lastName" name="lastName" required>
    </div>
    <div class="mb-3">
        <label for="group" class="form-label">Group</label>
        <select class="form-select form-control" id="group" name="group" required>
            <option selected disabled>Choose...</option>
            <%
                GroupDAO dao = new GroupDAO(DBConnect.getConn());
                List<Group> list = dao.getGroup();
                for (Group group : list) {
            %>
                <option value="<%= group.getGroupName() %>"><%= group.getGroupName() %></option>
            <%
                }
            %>
        </select>
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">Phone number</label>
        <input type="text" class="form-control" id="phone" name="phone"  required>
        <small class="form-text text-muted">Phone number must be 10 digits and start with 0.</small>
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<button type="button" class="btn btn-secondary mt-3" onclick="window.location.href='listContact.jsp'">Return to contact list</button>
<%@include file="footer.jsp" %>
