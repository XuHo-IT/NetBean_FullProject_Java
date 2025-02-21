<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator Result</title>
    </head>
    <body>
        <form action="Controller" method="POST">
            First:<input type="text" name="First" value="<%= request.getParameter("First") %>" />
            <br><br>
            Second:<input type="text" name="Second" value="<%= request.getParameter("Second") %>" />
            <br><br>
            <label for="Operator">Operator:</label>
            <select id="Operator" name="Operator">
                <option value="+" <%= request.getParameter("Operator").equals("+") ? "selected" : "" %>>+</option>
                <option value="-" <%= request.getParameter("Operator").equals("-") ? "selected" : "" %>>-</option>
                <option value="*" <%= request.getParameter("Operator").equals("*") ? "selected" : "" %>>*</option>
                <option value="/" <%= request.getParameter("Operator").equals("/") ? "selected" : "" %>>/</option>
            </select>
            <br><br>
            <input type="submit" value="Compute" placeholder="Compute">
            <br><br>
            Result:<input type="text" name="Result" placeholder="Result" value="<%= request.getAttribute("result") %>"/>
        </form>
        <br>
        <form action="index.html">
            <input type="submit" value="Back to Calculator">
        </form>
    </body>
</html>

