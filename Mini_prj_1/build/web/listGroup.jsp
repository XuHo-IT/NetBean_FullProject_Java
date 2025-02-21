<%-- 
    Document   : listgroup
    Created on : Jun 26, 2024, 1:15:21 PM
    Author     : OS
--%>

<%@page import="model.Group"%>
<%@page import="DAO.GroupDAO"%>
<%@page import="java.util.List"%>
<%@page import="Connect.DBConnect"%>
<%@page import="DAO.GroupDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Group List</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body {
            padding-top: 20px;
        }
        .container {
            max-width: 800px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mb-4">Group List</h1>
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Group Name</th>
                    <th scope="col">Description</th>    
                   
                </tr>
            </thead>
            <%
                GroupDAO dao = new GroupDAO(DBConnect.getConn());
                List<Group> list = dao.getGroup();
                for (Group group : list) {
            %>
            <tbody>
                <tr>
                    <th scope="row"><%= group.getId() %></th>
                    <td><%= group.getGroupName() %></td>
                    <td><%= group.getDescription() %></td>     
                   
                </tr>
            </tbody>
            <%
                }
            %>
        </table>
        <button type="button" class="btn btn-secondary" onclick="window.location.href='Group.jsp'">Add Group</button>
        <button type="button" class="btn btn-secondary" onclick="window.location.href='listContact.jsp'">List Contact</button>
    </div>

    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9yZdlbo0BjAlp8I1f3LWdB8VsZXM/pjYfUBoQ" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
