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
			<th>date</th>
			<th>numero</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="reservation" items="${reservations}">
			<tr>
				<td>${reservation.id}</td>
				<td><fmt:formatDate value="${reservation.date}"
						pattern="dd/MM/yyyy" /></td>
				<td>${reservation.numero}</td>
				<td><a class="btn btn-danger" href="./delete?id=${reservation.id}">supprimer</a></td>
				<td><a class="btn btn-info" href="./edit?id=${reservation.id}">editer</a></td>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-danger" href="./add">nouvelle reservation</a>
</body>
</html>