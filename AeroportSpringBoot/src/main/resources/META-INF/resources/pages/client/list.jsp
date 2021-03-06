<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Liste des clients</h1>

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="../vol/">vols</a></li>
					<li class="nav-item"><a class="nav-link" href="../login/">logins</a></li>
					<li class="nav-item"><a class="nav-link" href="../passager/">passagers</a></li>
					<li class="nav-item"><a class="nav-link" href="../client/">clients</a></li>
					<li class="nav-item"><a class="nav-link"
						href="../reservation/">reservations</a></li>
					<c:if test="${pageContext.request.userPrincipal.name!=null}">
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
				<th>statut</th>
				<th>ID</th>
				<th>titre</th>
				<th>prenom</th>
				<th>Nom</th>
				<th>Tél</th>
				<th>Email</th>
				<th>Adresse</th>
				<th>CP</th>
				<th>Ville</th>
				<th>Pays</th>
				<th>Siret</th>


			</tr>
			<c:forEach var="client" items="${clients}">
				<tr>
					<c:if test="${client.getClass().simpleName=='ClientEI'}">
						<td>Indépendant</td>
					</c:if>
					<c:if test="${client.getClass().simpleName=='ClientPhysique'}">
						<td>Client Physique</td>
					</c:if>
					<c:if test="${client.getClass().simpleName=='ClientMoral'}">
						<td>Entreprise</td>
					</c:if>

					<td>${client.id}</td>
					<td>${client.titre}</td>
					<td><c:if
							test="${client.getClass().simpleName!='ClientMoral'}">${client.prenom}</c:if></td>
					<td>${client.nom}</td>
					<td>${client.numeroTel}</td>
					<td>${client.email}</td>
					<td>${client.adresse.adresse}</td>
					<td>${client.adresse.codePostale}</td>
					<td>${client.adresse.ville}</td>
					<td>${client.adresse.pays}</td>
					<td><c:if
							test="${client.getClass().simpleName=='ClientMoral'}">${client.siret}</c:if></td>

					<td><a class="btn btn-danger" href="./del?id=${client.id}">
							supprimer</a></td>
					<td><a class="btn btn-warning" href="./edit?id=${client.id}">
							modifier</a></td>
				</tr>

			</c:forEach>

		</table>

		<a class="btn btn-success" href="./addClientPhysique"> Add client
			physique</a> <a class="btn btn-success" href="./addClientMoral"> Add
			client moral</a> <a class="btn btn-success" href="./addClientEI"> Add
			client indépendant</a>
	</div>
</body>
</html>