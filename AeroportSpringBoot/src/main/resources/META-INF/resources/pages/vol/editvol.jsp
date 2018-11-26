<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
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
					<form:label path="dateDepart">date de depart</form:label>
					<form:input type="date" path="dateDepart" cssClass="form-control" />
					<form:errors path="dateDepart"></form:errors>
				</div>
				
				<div class="form-group">
					<form:label path="dateArrivee">Date d'arrivee</form:label>
					<form:input type="date" path="dateArrivee" cssClass="form-control" />
					<form:errors path="dateArrivee"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="heureDepart">heure de depart</form:label>
					<form:input type="time" path="heureDepart" cssClass="form-control" />
					<form:errors path="heureDepart"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="heureArrivee">heure d'arrivee</form:label>
					<form:input type="time" path="heureArrivee" cssClass="form-control" />
					<form:errors path="heureArrivee"></form:errors>
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