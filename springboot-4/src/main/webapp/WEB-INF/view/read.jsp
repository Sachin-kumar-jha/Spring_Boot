<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
</head>
<body>

<h2>Employee Details</h2>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Date</th>
        <th>UCode</th>
    </tr>
    <c:forEach var="e" items="${emp}">
        <tr>
            <td><c:out value="${e.id}" /></td>
            <td><c:out value="${e.name}" /></td>
            <td><c:out value="${e.date}" /></td>
            <td><c:out value="${e.ucode}" /></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
