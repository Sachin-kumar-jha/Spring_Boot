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
${msg}
<h2>Employee Details</h2>
    <c:forEach var="e" items="${emp}">
            <li><c:out value="${e.id}" /></li>
            <li><c:out value="${e.name}" /></li>
            <li><c:out value="${e.date}" /></li>
            <li><c:out value="${e.ucode}" /></li>
            
            <a href="delete?id=${e.id}">Delete</a>
            
    </c:forEach>


</body>
</html>
