<%@page import="model.Contact"%>
<%@page import="java.util.List"%>
<%@page import="Connect.DBConnect"%>
<%@page import="DAO.ContactDAO"%>
<%@include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageTitle" value="Contact List"/>
<h1 class="my-4">Contact List</h1>
<table class="table table-striped">
    <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Group</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Operations</th>
        </tr>
    </thead>
    <tbody>
        <%
            ContactDAO dao = new ContactDAO(DBConnect.getConn());
            List<Contact> list = dao.getContact();
            for (Contact contact : list) {
        %>
        <tr>
            <th scope="row"><%= contact.getId() %></th>
            <td><%= contact.getFirstName() %></td>
            <td><%= contact.getLastName() %></td>
            <td><%= contact.getGroup() %></td>
            <td><%= contact.getPhone() %></td>
            <td>
                <a href="editContact.jsp?id=<%=contact.getId()%>" class="btn btn-sm btn-primary"><i class="fas fa-edit"></i> Edit</a>
                <a href="DeleteContactController?id=<%=contact.getId()%>" class="btn btn-sm btn-danger"><i class="fas fa-trash"></i> Delete</a> 
            </td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
<button type="button" class="btn btn-secondary mt-3" onclick="window.location.href='index.jsp'">Add Contact</button>
<button type="button" class="btn btn-secondary mt-3" onclick="window.location.href='listGroup.jsp'">List Group</button>
<%@include file="footer.jsp" %>
