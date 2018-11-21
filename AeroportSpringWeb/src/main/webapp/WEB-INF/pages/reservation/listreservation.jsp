<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Liste de Reservations</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="../vol/">vols</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../login/">logins</a></li>
						<li class="nav-item"><a class="nav-link"
						href="../passager/">passagers</a></li>
						<li class="nav-item"><a class="nav-link"
						href="../client/">clients</a></li>
						<li class="nav-item"><a class="nav-link"
						href="../reservation/">reservations</a></li>
				</ul>
			</div>
		</nav>
		<table class="table">
			<tr>
				<th>id</th>
				<th>date</th>
				<th>numero</th>
				<th>vol</th>
				<th>identifiant du client</th>
				<th>nom du client</th>
				<th>identifiant du passager</th>
				<th>nom du passager</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="reservation" items="${reservations}">
				<tr>
					<td>${reservation.id}</td>
					<td><fmt:formatDate value="${reservation.date}"
							pattern="dd/MM/yyyy" /></td>
					<td>${reservation.numero}</td>
					<td>${reservation.vol.id}</td>
					<td>${reservation.client.id}</td>
					<td>${reservation.client.nom}</td>
					<td>${reservation.passager.id}</td>
					<td>${reservation.passager.nom}</td>
					<td><a class="btn btn-danger"
						href="./delete?id=${reservation.id}">supprimer</a></td>
					<td><a class="btn btn-info" href="./edit?id=${reservation.id}">editer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-danger" href="./add">nouvelle reservation</a>

	</div>
</body>
</html>