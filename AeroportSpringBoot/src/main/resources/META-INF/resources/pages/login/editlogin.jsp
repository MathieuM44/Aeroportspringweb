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
<title>editer des logins</title>
</head>
<body>
	<div class="container">
		<fieldset>
			<legend> edition de logins </legend>
			<form:form action="./save" method="get" modelAttribute="log">
				<form:hidden path="version" />
				<div class="form-group">
					<form:label path="id">id</form:label>
					<form:input  path="id" readonly="true" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="login">login</form:label>
					<form:input path="login" cssClass="form-control" />
					<form:errors path="login">login</form:errors>
				</div>
				<div class="form-group">
					<form:label path="motDePasse">motDePasse</form:label>
					<form:input path="motDePasse" cssClass=" form-control" />
					<form:errors path="motDePasse">motDePasse</form:errors>
				</div>
				<div class="form-group">
					<form:label path="admin">admin</form:label>
					<form:input path="admin" cssClass=" form-control" />
					<form:errors path="admin"></form:errors>
				</div>
				<!-- 				<div class="form-group"> -->
				<%-- 					<form:label path="salle">salle</form:label> --%>
				<%-- 					<form:select path="salle.numero" cssClass=" form-control"> --%>
				<%-- 						<form:option value="">pas de salle</form:option> --%>
				<%-- 						<form:options items="${salles }" itemLabel="nom" itemValue="numero"/> --%>
				<%-- 					</form:select> --%>
				<!-- 				</div> -->
				<div class="form-group">
					<button type="submit" class=" btn btn-success">enregistrer</button>
					<a class="btn btn-danger" href="./">annuler</a>
				</div>
			</form:form>
		</fieldset>
	</div>
</body>
</html>