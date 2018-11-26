<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>liste des logins</title>
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
				<th>id</th>
				<th>login</th>
				<th>motDePasse</th>
				<th>admin</th>
			</tr>
			<c:forEach var="login" items="${logins}">
				<tr>
					<td>${login.id }</td>
					<td>${login.login }</td>
					<td>${login.motDePasse }</td>
					<td>${login.admin }</td>
					<td><a class="btn btn-danger" href="./delete?id=${login.id}">supprimer</a></td>
					<td><a class="btn btn-info" href="./editlogin?id=${login.id}">editer</a></td>
					<td><a class="btn btn-info" href="./voirclient?id=${login.id}">voir
							client</a></td>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-info" href="./addLogin"> nouveau login</a>
	</div>
</body>
</html>