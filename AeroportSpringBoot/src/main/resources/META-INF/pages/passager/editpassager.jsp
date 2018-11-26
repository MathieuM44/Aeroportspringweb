<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edition de passager</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>Edition de passager</legend>
			<form:form action="savePassager" method="post"
				modelAttribute="passager">
				<form:hidden path="version" />
				<div class="form-group">
					<form:label path="id">Id</form:label>
					<form:input path="id" readonly="true" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="nom">Nom</form:label>
					<form:input path="nom" cssClass="form-control" />
					<form:errors path="nom"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="prenom">Prénom</form:label>
					<form:input path="prenom" cssClass="form-control" />
					<form:errors path="prenom"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse">Adresse</form:label>
					<form:input path="adresse.adresse" cssClass="form-control" />
					<form:errors path="adresse"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse">Code Postal</form:label>
					<form:input path="adresse.codePostale" cssClass="form-control" />
					<form:errors path="adresse"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse">Ville</form:label>
					<form:input path="adresse.ville" cssClass="form-control" />
					<form:errors path="adresse"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse">Pays</form:label>
					<form:input path="adresse.pays" cssClass="form-control" />
					<form:errors path="adresse"></form:errors>
				</div>
				<div>
					<button class="btn btn-success" type="submit">Enregistrer</button>
					<a class="btn btn-warning" href="./">Annuler</a>
				</div>
			</form:form>
		</fieldset>
	</div>
</body>
</html>