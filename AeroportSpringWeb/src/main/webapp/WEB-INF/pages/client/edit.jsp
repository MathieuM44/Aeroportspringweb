<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

</head>
<body>

	<div class="container">
		<fieldset>

			<legend> edition du client</legend>

			<c:choose>
				<c:when test="${personne.getClass().simpleName=='ClientPhysique'}">
					<c:url value="saveClientPhysique" var="action"></c:url>
				</c:when>
				<c:when test="${personne.getClass().simpleName=='ClientMoral'}">
					<c:url value="saveClientMoral" var="action"></c:url>
				</c:when>
				<c:when test="${personne.getClass().simpleName=='ClientEI'}">
					<c:url value="saveClientEI" var="action"></c:url>
				</c:when>
			</c:choose>


			<form:form action="${action}" method="get" modelAttribute="personne">

				<form:hidden path="version" />

				<div class="form-group">
					<form:label path="id">id</form:label>
					<form:input path="id" readonly="true" cssClass="form-control" />
				</div>

				<div class="form-group">
					<form:label path="titre">civilite</form:label>
					<form:select path="titre" items="${titres}" itemLabel="titre"
						cssClass="form-control" />
				</div>

				<div class="form-group">
					<form:label path="nom">nom</form:label>
					<form:input path="nom" cssClass="form-control" />
					<form:errors path="nom"></form:errors>
				</div>

				<c:when test="${personne.getClass().simpleName!='ClientEI'}">
<div class="form-group">
					<form:label path="prenom">prenom</form:label>
					<form:input path="prenom" cssClass="form-control" />
					<form:errors path="prenom"></form:errors>
				</div>				</c:when>
				

				<div class="form-group">
					<form:label path="adresse.numero">numero</form:label>
					<form:input type="number" path="adresse.numero"
						cssClass="form-control" />
					<form:errors path="adresse.numero"></form:errors>
				</div>

				<div class="form-group">
					<form:label path="adresse.rue">rue</form:label>
					<form:input path="adresse.rue" cssClass="form-control" />
					<form:errors path="adresse.rue"></form:errors>
				</div>

				<div class="form-group">
					<form:label path="adresse.codePostal">numero</form:label>
					<form:input type="number" path="adresse.codePostal"
						cssClass="form-control" />
					<form:errors path="adresse.codePostal"></form:errors>
				</div>

				<div class="form-group">
					<form:label path="adresse.ville">numero</form:label>
					<form:input path="adresse.ville" />
					<form:errors path="adresse.ville"></form:errors>
				</div>

				<div class="form-group">
					<form:label path="dtNaiss">numero</form:label>
					<form:input type="date" path="dtNaiss" cssClass="form-control" />
					<form:errors path="dtNaiss"></form:errors>
				</div>


				<c:choose>
					<c:when test="${personne.getClass().simpleName=='Formateur'}">
						<div class="form-group">
							<form:label path="cout">cout</form:label>
							<form:input path="cout" cssClass="form-control" />
							<form:errors path="cout"></form:errors>
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-group">
							<form:label path="entreprise">entreprise</form:label>
							<form:input path="entreprise" cssClass="form-control" />
							<form:errors path="entreprise"></form:errors>
						</div>
					</c:otherwise>
				</c:choose>

				<div class="form-group">
					<form:label path="salle">salle</form:label>
					<form:select path="salle.numero" cssClass="form-control">

						<form:option value="">Pas de salle</form:option>
						<form:options items="${salles}" itemLabel="nom" itemValue="numero"></form:options>

					</form:select>
				</div>

				<button type="submit">enregistrer</button>
				<a class="btn btn-warning" href="./">annuler</a>




			</form:form>




		</fieldset>






	</div>

</body>
</html>