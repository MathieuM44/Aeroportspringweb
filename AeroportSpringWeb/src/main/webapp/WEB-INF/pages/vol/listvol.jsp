<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>liste des vols</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>id</th>
				<th>date de depart</th>
				<th>date d'arrivee</th>
				<th>Heure de Depart</th>
				<th>Heure d'Arrivee</th>

			</tr>
			<c:forEach var="vol" items="${vols}">
				<tr>
					<td>${vol.id}</td>
					<td><fmt:formatDate value="${vol.dateDepart}"
							pattern="dd/MM/yyyy" /></td>

					<td><fmt:formatDate value="${vol.dateArrivee}"
							pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${vol.heureDepart}"
							pattern="hh:mm:ss" /></td>
					<td><fmt:formatDate value="${vol.heureArrivee}"
							pattern="hh:mm:ss" /></td>

					<td><a class="btn btn-danger" href="./delete?id=${vol.id}">supprimer</a></td>
					<td><a class="btn btn-info" href="./editvol?id=${vol.id}">editer</a></td>
			</c:forEach>
		</table>
		<a class="btn btn-info" href="./addvol"> nouveau vol</a>
	</div>
</body>
</html>