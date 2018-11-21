<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>liste des personnes</title>
</head>
<body>

	<table class="table">
		<tr>
			<th>id</th>
			<th>titre</th>
			<th><spring:message code="personne.list.prenom"></spring:message></th>
			<th><spring:message code="personne.list.nom"></spring:message></th>
			<th>date de naissance</th>
			<th>adresse</th>
			<th>code postal</th>
			<th>ville</th>
			<th>cout</th>
			<th>entreprise</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="personne" items="${personnes}">
			<tr>
				<td>${personne.id}</td>
				<td>${personne.titre}</td>
				<td>${personne.prenom}</td>
				<td>${personne.nom}</td>
				<td><fmt:formatDate value="${personne.dtNaiss}"
						pattern="dd/MM/yyyy" /></td>
				<td>${personne.adresse.numero}${personne.adresse.rue}</td>
				<td>${personne.adresse.codePostal}</td>
				<td>${personne.adresse.ville}</td>
				<td><c:if
						test="${personne.getClass().name=='formationJpa.model.Formateur'}">${personne.cout}</c:if>
				</td>
				<td><c:if test="${personne.getClass().simpleName=='Stagiaire'}">${personne.entreprise}</c:if>
				</td>
				<td><a class="btn btn-danger" href="./delete?id=${personne.id}">supprimer</a></td>
				<td><a class="btn btn-info" href="./edit?id=${personne.id}">editer</a></td>
			</tr>
		</c:forEach>
	</table>

	<a class="btn btn-info" href="./addFormateur">nouveau formateur</a>
	<a class="btn btn-info" href="./addStagiaire">nouveau stagiaire</a>
</body>
</html>