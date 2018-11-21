<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>editer des vols</title>
</head>
<body>
	<div class="container">
		<fieldset>
			<legend> edition de vols </legend>
			<form:form action="./savevol" method="post" modelAttribute="vol">
				<form:hidden path="version" />
				<div class="form-group">
					<form:label path="id">id</form:label>
					<form:input path="id" readonly="true" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="date">Date de depart</form:label>
					<form:input path="date" cssClass="form-control" />
					<form:errors path="date">Date de depart</form:errors>
				</div>
				<div class="form-group">
					<form:label path="date">Date d'arrivee</form:label>
					<form:input path="date" cssClass="form-control" />
					<form:errors path="date">Date d'arrivee</form:errors>
				</div>
				<div class="form-group">
					<form:label path="date">heure de depart</form:label>
					<form:input type="date" path="date" cssClass="form-control" />
					<form:errors path="date"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="date">heure d'arrivee</form:label>
					<form:input type="date" path="date" cssClass="form-control" />
					<form:errors path="date"></form:errors>
				</div>
				<div>
					<div class="form-group">
						<button type="submit" class=" btnbtn-success">enregistrer</button>
						<a class="btn btn-danger" href="./">annuler</a>
					</div>
			</form:form>
		</fieldset>
	</div>
</body>
</html>