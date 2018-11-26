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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
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
					<c:if test="${pageContext.request.userPrincipal.name!=null }">
						<li class="nav-item"><a class="nav-link" href="../logout">logout</a>
						</li>
						<li class="nav-item">logged as
							${pageContext.request.userPrincipal.name}</li>
					</c:if>
				</ul>
			</div>
		</nav>
		<table class="table">
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Adresse</th>
				<th>Code postal</th>
				<th>Ville</th>
				<th>Pays</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="passager" items="${passagers}">
				<tr>
					<td>${passager.id}</td>
					<td>${passager.nom}</td>
					<td>${passager.prenom}</td>
					<td>${passager.adresse.adresse}</td>
					<td>${passager.adresse.codePostale}</td>
					<td>${passager.adresse.ville}</td>
					<td>${passager.adresse.pays}</td>
					<td><a class="btn btn-danger"
						href="./delete?id=${passager.id}">Supprimer</a></td>
					<td><a class="btn btn-info" href="./edit?id=${passager.id}">Editer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-info" href="./addPassager">Nouveau passager</a>
	</div>
</body>
</html>