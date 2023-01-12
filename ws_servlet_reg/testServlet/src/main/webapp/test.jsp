<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
<form action="mainServlet" method="post">
<input type="text" name="name" placeholder="enter name"><br>
<input type="text" name="country" placeholder="enter country"><br>
<input type="email" name="email" placeholder="enter email"><br>
<input type="text" name="username" placeholder="enter username"><br>
<input type="password" name="password" placeholder="enter password"><br>
<input type="submit" name="submit">
<a href="editServlet">Edit</a>
</form>
</body>
</html>