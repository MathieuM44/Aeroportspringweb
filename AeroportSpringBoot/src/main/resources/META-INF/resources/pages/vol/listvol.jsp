<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>liste des vols</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="../vol/">vols</a></li>
					<li class="nav-item"><a class="nav-link" href="../login/">logins</a></li>
					<li class="nav-item"><a class="nav-link" href="../passager/">passagers</a></li>
					<li class="nav-item"><a class="nav-link" href="../client/">clients</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../reservation/">reservations</a></li>
				</ul>
			</div>
		</nav>
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
					<td><fmt:formatDate value="${vol.heureDepart}" pattern="HH:mm" /></td>
					<td><fmt:formatDate value="${vol.heureArrivee}"
							pattern="HH:mm" /></td>

					<td><a class="btn btn-danger" href="./delete?id=${vol.id}">supprimer</a></td>
					<td><a class="btn btn-info" href="./editvol?id=${vol.id}">editer</a></td>
			</c:forEach>
		</table>
		<a class="btn btn-info" href="./addvol"> nouveau vol</a>
	</div>
</body>
</html>