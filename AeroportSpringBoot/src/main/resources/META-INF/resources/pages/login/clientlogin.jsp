<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>informations clients</title>
</head>
<body>
	<table class="table">
		<tr>
			<th>id</th>
			<th>nom</th>
			<th>numeroTel</th>
			<th>numeroFax</th>
			<th>email</th>
			<th>adresse</th>
		</tr>
			<tr>
				<td>${client.id }</td>
				<td>${client.nom }</td>
				<td>${client.numeroTel }</td>
				<td>${client.numeroFax }</td>
				<td>${client.email }</td>
				<td>${client.adresse.adresse }</td>
				<%-- 				<td><a class="btn btn-danger" href="./delete?id=${login.id}">supprimer</a></td> --%>
				<%-- 				<td><a class="btn btn-info" href="./editlogin?id=${login.id}">editer</a></td> --%>
				<%-- 				<td><a class="btn btn-info" href="./editlogin?id=${login.id}">voir --%>
				<!-- 						client</a></td> -->
	</table>
	<a class="btn btn-info" href="./"> retour</a>

</body>
</html>