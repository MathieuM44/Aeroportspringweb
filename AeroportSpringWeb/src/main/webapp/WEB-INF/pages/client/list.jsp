<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<tr>
			<th>ID</th>
<!-- 			<th>titre</th> -->
<!-- 			<th>prénom</th> -->
<!-- 			<th>nom</th> -->
<!-- 			<th>date de naissance</th> -->
<!-- 			<th>adresse</th> -->
<!-- 			<th>code postale</th> -->
<!-- 			<th>ville</th> -->
<!-- 			<th>cout</th> -->
<!-- 			<th>entreprise</th> -->
<!-- 			<th>salle</th> -->
<!-- 			<th></th> -->
<!-- 			<th></th> -->
		</tr>
		<c:forEach var="client" items="${clients}">
			<tr>
				<td>${client.id}</td>
<%-- 				<td>${personne.titre}</td> --%>
<%-- 				<td>${personne.prenom}</td> --%>
<%-- 				<td>${personne.nom}</td> --%>
<%-- 				<td><fmt:formatDate value="${personne.dtNaiss}" --%>
<%-- 						pattern="dd/MM/yyyy" /></td> --%>
<%-- 				<td>${personne.adresse.numero}${personne.adresse.rue}</td> --%>

<%-- 				<td>${personne.adresse.codePostal}</td> --%>

<%-- 				<td>${personne.adresse.ville}</td> --%>
<%-- 				<td><c:if test="${personne.getClass().simpleName=='Formateur'}">${personne.cout}</c:if></td> --%>
<%-- 				<td><c:if test="${personne.getClass().simpleName=='Stagiaire'}">${personne.entreprise}</c:if></td> --%>
				
<%-- 				<td>${personne.salle.nom}</td> --%>

				<td><a href="./delete?id=${personne.id}"> supprimer</a></td>
				<td><a href="./edit?id=${personne.id}"> modifier</a></td>
			</tr>

		</c:forEach>

	</table>

	<a href="./addClient"> Add client</a>
</body>
</html>