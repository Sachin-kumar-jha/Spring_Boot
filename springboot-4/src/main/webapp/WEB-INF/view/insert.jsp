<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="message" items="${msg}">
   <li>${message}</li>
</c:forEach>

 <!-- Form to take Employee details -->
    <form action="insert" method="post">
        <label for="id">Employee ID:</label>
        <input type="text" name="id" id="id" required><br><br>
        
        <label for="name">Employee Name:</label>
        <input type="text" name="name" id="name" required><br><br>
        <label for="date">DATE:</label>
        <input type="date" name="date" id="date" required><br><br>
        <input type="submit" value="Submit">
        
    </form>
</body>
</html>