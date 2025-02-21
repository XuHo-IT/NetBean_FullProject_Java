<%@page import="model.Contact"%>
<%@page import="java.util.List"%>
<%@page import="Connect.DBConnect"%>
<%@page import="DAO.ContactDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Edit Contact</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            body {
                padding-top: 20px;
            }
            .container {
                max-width: 600px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="text-center">Edit Contact</h3>
                        </div>
                        <div class="card-body">
                            <%
                                ContactDAO dao = new ContactDAO(DBConnect.getConn());
                                int id = Integer.parseInt(request.getParameter("id"));
                                Contact b = dao.getContactById(id);
                            %>
                            <form action="EditContactController" method="post">
                                <input type="hidden" name="id" value="<%=b.getId()%>">
                                <div class="mb-3">
                                    <label for="firstName" class="form-label">First Name</label>
                                    <input type="text" class="form-control" id="firstName" name="firstName" value="<%=b.getFirstName()%>" required>
                                </div>
                                <div class="mb-3">
                                    <label for="lastName" class="form-label">Last Name</label>
                                    <input type="text" class="form-control" id="lastName" name="lastName" value="<%=b.getLastName()%>" required>
                                </div>
                                <div class="mb-3">
                                    <label for="groups" class="form-label">Group</label>
                                    <input type="text" class="form-control" id="groups" name="groups" value="<%=b.getGroup()%>" required>
                                </div>
                                <div class="mb-3">
                                    <label for="phone" class="form-label">Phone number</label>
                                    <input type="text" class="form-control" id="phone" name="phone" pattern="0[0-9]{9}" value="<%=b.getPhone()%>" required>
                                    <small class="form-text text-muted">Phone number must be 10 digits and start with 0.</small>
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Edit Contact</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9yZdlbo0BjAlp8I1f3LWdB8VsZXM/pjYfUBoQ" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
