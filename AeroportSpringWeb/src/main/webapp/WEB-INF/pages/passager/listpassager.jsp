<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des passagers</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<table class="table">
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="passager" items="${passagers}">
			<tr>
				<td>${passager.id}</td>
				<td>${passager.nom}</td>
				<td>${passager.prenom}</td>
				<td><a class="btn btn-danger" href="./delete?id=${passager.id}">Supprimer</a></td>
				<td><a class="btn btn-info" href="./edit?id=${passager.id}">Editer</a></td>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-info" href="./addPassager">Nouveau passager</a>
</body>
</html>