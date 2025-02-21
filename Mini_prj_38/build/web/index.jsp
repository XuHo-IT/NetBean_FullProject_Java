
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="a" method="POST">
            <h1>Hello World!</h1>
            Nhap n <input type="text" name="Soluong"><br><br>
            <input type="submit" name="Phatsinh" value="1"><br><br>
            <%
              String s = request.Getparameter("Soluong");
              if (s!=null){
                int n = Interger.parseInt(s);
                for (int i=0; i<n;i++){
                   out.println("<br>" +i +"<br>");
                }
                }else{
                out.println("Nhap lai")
                }
            %>
        </form>
    </body>
</html>
