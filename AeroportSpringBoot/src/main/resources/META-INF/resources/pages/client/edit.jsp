<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<fieldset>

			<legend> edition du client</legend>

			<c:if test="${client.getClass().simpleName=='ClientPhysique'}">
				<c:url value="saveClientPhysique" var="action"></c:url>
			</c:if>

			<c:if test="${client.getClass().simpleName=='ClientMoral'}">
				<c:url value="saveClientMoral" var="action"></c:url>
			</c:if>

			<c:if test="${client.getClass().simpleName=='ClientEI'}">
				<c:url value="saveClientEI" var="action"></c:url>
			</c:if>



			<form:form action="${action}" method="get" modelAttribute="client">

				<form:hidden path="version" />

				<div class="form-group">
					<form:label path="id">id</form:label>
					<form:input path="id" readonly="true" cssClass="form-control" />
				</div>

				<div class="form-group">
					<form:label path="titre">civilite</form:label>

					<c:if test="${client.getClass().simpleName=='ClientPhysique'}">
						<form:select path="titre" items="${titresP}" itemLabel="titre"
							cssClass="form-control" />
					</c:if>
					<c:if test="${client.getClass().simpleName=='ClientEI'}">
						<form:select path="titre" items="${titresP}" itemLabel="titre"
							cssClass="form-control" />
					</c:if>
					<c:if test="${client.getClass().simpleName=='ClientMoral'}">
						<form:select path="titre" items="${titresM}" itemLabel="titre"
							cssClass="form-control" />
					</c:if>
				</div>

				<c:if test="${flag=='edit'}">
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<c:if test="${client.getClass().simpleName != 'ClientMoral'}">
							<div class="form-group">
								<form:label path="prenom">prenom</form:label>
								<form:input path="prenom" cssClass="form-control" />
								<form:errors path="prenom"></form:errors>
							</div>
						</c:if>

						<div class="form-group">
							<form:label path="nom">nom</form:label>
							<form:input path="nom" cssClass="form-control" />
							<form:errors path="nom"></form:errors>
						</div>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_USER')">
						<div class="form-group">
							<form:label path="prenom">prenom</form:label>
							<form:input readonly="true" path="prenom" cssClass="form-control" />
							<form:errors path="prenom"></form:errors>
						</div>

						<div class="form-group">
							<form:label path="nom">nom</form:label>
							<form:input readonly="true" path="nom" cssClass="form-control" />
							<form:errors path="nom"></form:errors>
						</div>

					</sec:authorize>
				</c:if>
				<c:if test="${flag=='create'}">
					<c:if test="${client.getClass().simpleName != 'ClientMoral'}">
						<div class="form-group">
							<form:label path="prenom">prenom</form:label>
							<form:input path="prenom" cssClass="form-control" />
							<form:errors path="prenom"></form:errors>
						</div>
					</c:if>

					<div class="form-group">
						<form:label path="nom">nom</form:label>
						<form:input path="nom" cssClass="form-control" />
						<form:errors path="nom"></form:errors>
					</div>
				</c:if>

				<div class="form-group">
					<form:label path="adresse.adresse">adresse</form:label>
					<form:input path="adresse.adresse" cssClass="form-control" />
					<form:errors path="adresse.adresse"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse.ville">ville</form:label>
					<form:input path="adresse.ville" cssClass="form-control" />
					<form:errors path="adresse.ville"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse.pays">pays</form:label>
					<form:input path="adresse.pays" cssClass="form-control" />
					<form:errors path="adresse.pays"></form:errors>
				</div>
				<table class="table">
					<tr>

						<th>ID</th>
						<th>numero</th>

					</tr>
					<c:forEach var="resa" items="${reservations}">
						<tr>

							<td>${resa.id}</td>
							<td>${resa.numero}</td>

							<td><a href="./del?id=${client.id}"> supprimer</a></td>
							<td><a href="./edit?id=${client.id}"> modifier</a></td>
						</tr>

					</c:forEach>

				</table>
				<button class="btn btn-success" type="submit">enregistrer</button>
				<a class="btn btn-danger" href="./"> annuler</a>
			</form:form>




		</fieldset>






	</div>

</body>
</html>