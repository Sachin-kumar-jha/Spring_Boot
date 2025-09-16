<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- Form to take Employee details -->
    <form action="insert" method="post">
        <label for="id">Employee ID:</label>
        <input type="text" name="id" id="id" required><br><br>
        
        <label for="name">Employee Name:</label>
        <input type="text" name="name" id="name" required><br><br>
        <input type="submit" value="Submit">
        
    </form>
</body>
</html>