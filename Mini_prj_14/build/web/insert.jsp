<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add student</title>
</head>
<section>
    <h1>Add New Human to System</h1>
    <br><br>
    <form action="InsertController" method="POST">
        <label>Human ID:</label>
        <input type="text" name="id" required/><br><br>
        <label>Human Name:</label>
        <input type="text" name="name" required/><br><br>
        <label>Human Gender:</label>
        <input type="radio" name="gender" value="Male" required/>Male
        <input type="radio" name="gender" value="Female" required/>Female<br><br>
        <label>Human DOB:</label>
        <input type="date" name="dob" required/><br><br>
        <label>Type ID:</label>
        <input type="text" name="Typeid" required/><br><br>
        <input type="submit" value="Add" />
    </form>
</section>
</html>
