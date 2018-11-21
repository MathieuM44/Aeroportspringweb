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
	<table class="table">
		<tr>
			<th>id</th>
			<th>titre</th>
			<th>prenom</th>
			<th>nom</th>
			<th>date de naissance</th>
			<th>adresse</th>
			<th>code postal</th>
			<th>ville</th>
			<th>cout</th>
			<th>entreprise</th>
			<th>salle</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="reservation" items="${reservations}">
		</c:forEach>
	</table>
	<a class="btn btn-danger" href="./add">nouvelle reservation</a>
</body>
</html>