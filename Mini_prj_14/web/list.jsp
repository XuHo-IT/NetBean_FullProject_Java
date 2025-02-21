<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="model.Human" %>
<%@ page import="model.HumanType" %>
<%@ page import="Connect.DBContext" %>
<!DOCTYPE html>
<html>
<head>
    <title>Human List</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Human List</h2>
    <table class="table table-sm table-dark">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">DOB</th>
            <th scope="col">Gender</th>
            <th scope="col">Type</th>
            <th scope="col">Actions</th> <!-- Added Actions column header -->
        </tr>
        </thead>
        <tbody>
        <% 
        DBContext db = new DBContext();
        ArrayList<Human> humans = db.getHumans();
        ArrayList<HumanType> types = db.getTypes();
        
        Map<Integer, String> typeMap = new HashMap<>();
        for (HumanType type : types) {
            typeMap.put(type.getTypeId(), type.getTypeName());
        }
        for (Human human : humans) {
        %>
        <tr>
            <td><%= human.getHumanId() %></td>
            <td><%= human.getHumanName() %></td>
            <td><%= human.getHumanDob() %></td>
            <td><%= human.getHumanGender() ? "Male" : "Female" %></td>
            <td><%= typeMap.get(human.getHumanType().getTypeId()) %></td>
            <td>
                <!-- Update button -->
                <form action="UpdateController" method="post" style="display: inline;">
                    <input type="hidden" name="id" value="<%= human.getHumanId() %>"/>
                    <button type="submit" class="btn btn-sm">Update</button>
                </form>
                <!-- Delete button -->
                <form action="UpdateController" method="post" style="display: inline;">
                    <input type="hidden" name="id" value="<%= human.getHumanId() %>"/>
                    <button type="submit" class="btn btn-sm">Delete</button>
                </form>
            </td>
        </tr>
        <% 
        } 
        %>
        </tbody>
    </table>
    <form action="insert.jsp" method="get">
        <button type="submit" class="btn btn-primary">Add</button>
    </form>
</div>
</body>
</html>
