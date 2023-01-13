<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Record</title>
</head>
<body align="center">
<form action="editServlet" method="post">
<table align="center">
<tr>
<td>ID:</td>
<td><input type="text" name="id" placeholder="Enter Id"></td>
</tr>
<tr>
<td>Name:</td>
<td><input type="text" name="name" placeholder="Enter Name"></td>
</tr>
<tr>
<td>Country:</td>
<td><input type="text" name="country" placeholder="Enter Country"></td>
</tr>
<tr>
<td>Email:</td>
<td><input type="email" name="email" placeholder="Enter Email"></td>
</tr>
<tr>
<td>Username:</td>
<td><input type="text" name="username" placeholder="Enter Username"></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password" placeholder="Enter Password"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="submit"></td>
</tr>
</table>

</body>
</html>