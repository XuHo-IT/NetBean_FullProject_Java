<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dummies</title>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
crossorigin="anonymous">
</head>

<body>

<main class="m-3">
<div class="row col-md-6">
<table class="table table-striped table-bordered table-sm">
<tr>
<th>Id</th>
<th>Name</th>
</tr>

<c:forEach items="${dummies}" var="dummy">
<tr>
<td>${dummy.getId()}</td>
<td>${dummy.getName()}</td>
</tr>
</c:forEach>
</table>
</div>

<nav aria-label="Navigation for countries">
<ul class="pagination">
<c:if test="${currentPage != 1}">
<li class="page-item"><a class="page-link"
href="ReadDummy?recordsPerPage=${recordsPerPage}&&currentPage=${currentPage-1}">Previous</a>
</li>
</c:if>

<c:forEach begin="1" end="${noOfPages}" var="i">
<c:choose>
<c:when test="${currentPage eq i}">
<li class="page-item active"><a class="page-link">
${i} <span class="sr-only">(current)</span></a>
</li>
</c:when>
<c:otherwise>
<li class="page-item"><a class="page-link"
href="ReadDummy?recordsPerPage=${recordsPerPage}&&currentPage=${i}">${i}</a>
</li>
</c:otherwise>
</c:choose>
</c:forEach>

<c:if test="${currentPage lt noOfPages}">
<li class="page-item"><a class="page-link"
href="ReadDummy?recordsPerPage=${recordsPerPage}&&currentPage=${currentPage+1}">Next</a>
</li>
</c:if>
</ul>
</nav>
</main>

</body>
</html>
