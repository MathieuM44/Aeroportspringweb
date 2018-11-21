<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>liste des logins</title>
</head>
<body>
	<table class="table">
		<tr>
			<th>id</th>
			<th>login</th>
			<th>motDePasse</th>
			<th>admin</th>
		</tr>
		<c:forEach var="login" items="${logins}">
			<tr>
				<td>${login.id }</td>
				<td>${login.login }</td>
				<td>${login.motDePasse }</td>
				<td>${login.admin }</td>
				<td><a class="btn btn-danger" href="./delete?id=${login.id}">supprimer</a></td>
				<td><a class="btn btn-info" href="./editlogin?id=${login.id}">editer</a></td>
				<td><a class="btn btn-info" href="./voirclient?id=${login.id}">voir
						client</a></td>
		</c:forEach>
	</table>
	<a class="btn btn-info" href="./addLogin"> nouveau login</a>
</body>
</html>