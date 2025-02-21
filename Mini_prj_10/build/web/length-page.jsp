 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <!DOCTYPE html>
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF8">
 <title>JSP Page</title>
 </head>
 <body>
 <h1>JSTL Function
 <hr>
 <c:set var="data" value="Mr A"></c:set>
 Length of the string <b>${data}</b>: ${fn:length(data)}
 <br><br>
 Uppercase <b>${data}</b>: ${fn:toUpperCase(data)}
 <br><br>
 Does the string <b>${data}</b> start with <b>Mr</b>?:
${fn:startsWith(data,"Mr")}
 </h1>
 </body>
 </html>
